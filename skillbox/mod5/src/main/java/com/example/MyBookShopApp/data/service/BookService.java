package com.example.MyBookShopApp.data.service;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepository) {
        this.bookRepo = bookRepository;
    }

    public List<Book> getBooksData(){
        return bookRepo.findAll();
    }
}
