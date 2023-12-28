package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.BooksPageDto;
import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Api(description = "authors data")
public class AuthorsController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        return authorService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorsPage() {
        return "/authors/index";
    }

    @ApiOperation("method to get map of authors")
    @GetMapping("/api/authors")
    @ResponseBody
    public Map<String, List<Author>> authors() {
        return authorService.getAuthorsMap();
    }

    @GetMapping(value = {"/books/author", "/books/author/{authorID}/index"})
    public String authorResult(@PathVariable(value = "authorID", required = false) Integer id,
                               Model model) {
        model.addAttribute("author_id", id);
        model.addAttribute("author", authorService.getAuthor(id));
        model.addAttribute("authorBooks", authorService.getPageAuthorBooks(id, 0, 6).getContent());
        return "authors/slug";
    }

    @GetMapping(value = {"/books/author", "/books/author/{authorID}"})
    @ResponseBody
    public BooksPageDto getAuthorBooksPage(@RequestParam("offset") Integer offset,
                                           @RequestParam("limit") Integer limit,
                                           @RequestParam(value = "authorID", required = false) Integer id) {
         return new BooksPageDto(authorService.getPageAuthorBooks(id, offset, limit).getContent());
    }
}
