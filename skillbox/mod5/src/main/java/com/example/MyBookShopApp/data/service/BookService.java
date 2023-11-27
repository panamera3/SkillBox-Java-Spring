package com.example.MyBookShopApp.data.service;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    //NEW BOOK SERVICE METHODS

    public List<Book> getBooksByAuthor(String authorName){
        return bookRepo.findBooksByAuthorFirstNameContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepo.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max){
        return bookRepo.findBooksByPriceOldBetween(min, max);
    }

    public List<Book> getBooksWithPrice(Integer price){
        return bookRepo.findBooksByPriceOldIs(price);
    }

    public List<Book> getBooksWithMaxPrice(){
        return bookRepo.getBooksWithMaxDiscount();
    }

    public List<Book> getBestsellers(){
        return bookRepo.getBestsellers();
    }

    public Page<Book> getPageofRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepo.findAll(nextPage);
    }

    public Page<Book> getPageofRecentBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findAll(nextPage);
    }

    public Page<Book> getPageofRecentBooks(Integer offset, Integer limit, Date from, Date to){
        Pageable nextPage = PageRequest.of(offset,limit, Sort.by("pub_date").ascending());
        return bookRepo.findBooksByDateBetween(from, to, nextPage);
    }

    public Page<Book> getPageofPopularBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepo.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepo.findBookByTitleContaining(searchWord,nextPage);
    }
}
