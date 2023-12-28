package com.example.MyBookShopApp.data.service;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.repo.AuthorRepo;
import com.example.MyBookShopApp.data.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    @Autowired
    public AuthorService(AuthorRepo authorRepo,BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        return getAuthorsList().stream().collect(Collectors.groupingBy((Author a) -> {
            return a.getLastName().substring(0, 1);
        }));
    }

    public List<Author> getAuthorsList() {
        return authorRepo.findAll();
    }

    public Author getAuthor(Integer id){
        return authorRepo.getById(id);
    }

    public Page<Book> getPageAuthorBooks(Integer author_id, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findByAuthorId(author_id, nextPage);
    }
}
