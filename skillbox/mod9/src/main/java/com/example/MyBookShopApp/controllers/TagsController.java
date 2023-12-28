package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.BooksPageDto;
import com.example.MyBookShopApp.data.SearchWordDto;
import com.example.MyBookShopApp.data.service.AuthorService;
import com.example.MyBookShopApp.data.service.BookService;
import com.example.MyBookShopApp.data.service.BooksRatingAndPopulatityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class TagsController {


    private final BookService bookService;
    private final BooksRatingAndPopulatityService booksRatingAndPopulatityService;

    @Autowired
    public TagsController(BookService bookService, BooksRatingAndPopulatityService booksRatingAndPopulatityService) {
        this.bookService = bookService;
        this.booksRatingAndPopulatityService = booksRatingAndPopulatityService;
    }
}
