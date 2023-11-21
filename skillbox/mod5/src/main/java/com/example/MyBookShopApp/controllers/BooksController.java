package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.service.AuthorService;
import com.example.MyBookShopApp.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/recent")
    public String recentPage(Model model) {
        model.addAttribute("booksData", bookService.getBooksData());
        return "books/recent";
    }

    @GetMapping("/popular")
    public String popularPage(Model model) {
        model.addAttribute("booksData", bookService.getBooksData());
         return "books/popular";
    }
}
