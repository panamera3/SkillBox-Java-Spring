package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BooksPageDto;
import com.example.MyBookShopApp.data.SearchWordDto;
import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.book.Tag;
import com.example.MyBookShopApp.data.service.BookService;
import com.example.MyBookShopApp.errs.EmptySearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookService.getPageofRecommendedBooks(0, 6).getContent();
    }

    @ModelAttribute("recentBooks")
    public List<Book> recentBooks() {
        return bookService.getPageofRecentBooks(0, 6).getContent();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks() {
        return bookService.getPageofPopularBooks(0, 6).getContent();
    }

    @ModelAttribute("allTags")
    public List<Tag> allTags() {
        List<Tag> example = bookService.getTags();
        return bookService.getTags();
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        return "index";
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults() {
        return new ArrayList<>();
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBooksPage(@RequestParam("offset") Integer offset,
                                     @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageofRecommendedBooks(offset, limit).getContent());
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @GetMapping(value = {"/search", "/search/{searchWord}"})
    public String getSearchResult(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                  Model model) throws EmptySearchException {
        if(searchWordDto!=null){

            model.addAttribute("searchWordDto", searchWordDto);
            model.addAttribute("searchResults",
                    bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), 0, 5).getContent());
            return "/search/index";
        } else {
            throw new EmptySearchException("Поиск по null невозможен");
        }
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit,
                                          @PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto) {
        return new BooksPageDto(bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), offset, limit).getContent());
    }

    @GetMapping(value = {"/tags", "/tags/{tagId}/index"})
    public String tagsBooksResult(@PathVariable(value = "tagId", required = false) Integer tag_id,
                                  Model model) {
        Integer actualTagId = tag_id - 1;
        model.addAttribute("current_tag_id", actualTagId);
        model.addAttribute("current_tag_name", bookService.getTags().get(actualTagId).getName());
        model.addAttribute("books",
                bookService.getPageTagsBooks(tag_id, 0, 5).getContent());
        return "tags/index";
    }

    @GetMapping(value = {"/books/tag", "/books/tag/{tagId}"})
    @ResponseBody
    public BooksPageDto getRecentBooksPage(@RequestParam("offset") Integer offset,
                                           @RequestParam("limit") Integer limit,
                                           @RequestParam(value = "tagId", required = false) Integer tag_id) {
        if(tag_id != null)
            return new BooksPageDto(bookService.getPageTagsBooks(tag_id, offset, limit).getContent());
        return new BooksPageDto(bookService.getPageTagsBooks(offset, limit).getContent());
    }
}
