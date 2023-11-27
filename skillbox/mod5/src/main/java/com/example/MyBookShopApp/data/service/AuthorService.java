package com.example.MyBookShopApp.data.service;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;

    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        return getAuthorsList().stream().collect(Collectors.groupingBy((Author a) -> {
            return a.getLastName().substring(0, 1);
        }));
    }

    public List<Author> getAuthorsList() {
        return authorRepo.findAll();
    }
}
