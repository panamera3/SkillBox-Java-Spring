package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BooksPageDto;
import com.example.MyBookShopApp.data.SearchWordDto;
import com.example.MyBookShopApp.data.service.AuthorService;
import com.example.MyBookShopApp.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/recent/index")
    public String recentPage(Model model) {
        model.addAttribute("booksData", bookService.getPageofRecentBooks(0, 5).getContent());
        return "books/recent";
    }

    @GetMapping("/recent")
    @ResponseBody
    public BooksPageDto getRecentBooksPage(@RequestParam("offset") Integer offset,
                                           @RequestParam("limit") Integer limit,
                                           @RequestParam(value = "from", required = false) Date from,
                                           @RequestParam(value = "to", required = false) Date to) {
        if(from != null && to != null)
            return new BooksPageDto(bookService.getPageofRecentBooks(offset, limit, from, to).getContent());
        return new BooksPageDto(bookService.getPageofRecentBooks(offset, limit).getContent());
    }

    @GetMapping("/popular/index")
    public String popularPage(Model model) {
        model.addAttribute("booksData", bookService.getBooksData());
        return "books/popular";
    }

    @GetMapping("/popular")
    @ResponseBody
    public BooksPageDto getBooksPopularPage(@RequestParam("offset") Integer offset,
                                            @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageofPopularBooks(offset, limit).getContent());
    }


    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }
}
