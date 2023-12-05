package com.example.MyBookShopApp.data.service;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.book.Tag;
import com.example.MyBookShopApp.data.repo.BookRepo;
import com.example.MyBookShopApp.data.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;
    private final TagRepo tagRepo;
    private final BooksRatingAndPopulatityService booksRatingAndPopulatityService;

    @Autowired
    public BookService(BookRepo bookRepository, TagRepo tagRepo, BooksRatingAndPopulatityService booksRatingAndPopulatityService) {
        this.bookRepo = bookRepository;
        this.tagRepo = tagRepo;
        this.booksRatingAndPopulatityService = booksRatingAndPopulatityService;
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
        return bookRepo.findBooksByPriceBetween(min, max);
    }

    public List<Book> getBooksWithPrice(Integer price){
        return bookRepo.findBooksByPriceIs(price);
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
        List<Book> books = bookRepo.findAll();
        for (Book book : books) {
            double popularity = booksRatingAndPopulatityService.calculatePopularity(book.getId());
            book.setPopularity(popularity);
            bookRepo.save(book);
        }
        Pageable nextPage = PageRequest.of(offset,limit, Sort.by("popularity").descending());
        return bookRepo.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepo.findBookByTitleContaining(searchWord,nextPage);
    }

    public Page<Book> getPageTagsBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findAll(nextPage);
    }

    public Page<Book> getPageTagsBooks(Integer tag_id, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findByTagId(tag_id, nextPage);
    }

    public List<Tag> getTags() {
        List<Book> books = bookRepo.findAll();
        List<Tag> tags = tagRepo.findAll();
        List<Integer> counts = new ArrayList<>(Collections.nCopies(tags.size(), 0));
        for (Book book : books) {
            Integer tagIdInBook = book.getTag().getId() - 1;
            counts.set(tagIdInBook, counts.get(tagIdInBook) + 1);
        }
        for(Tag tag: tags){
            tag.setBook_count(counts.get(tag.getId()-1));
            tagRepo.save(tag);
        }
        return tags;
    }
}
