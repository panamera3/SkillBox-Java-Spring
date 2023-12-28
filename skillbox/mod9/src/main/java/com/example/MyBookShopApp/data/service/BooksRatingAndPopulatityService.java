package com.example.MyBookShopApp.data.service;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksRatingAndPopulatityService {

    private final BookRepo bookRepo;

    @Autowired
    public BooksRatingAndPopulatityService(BookRepo bookRepository) {
        this.bookRepo = bookRepository;
    }

    public double calculatePopularity(Integer bookId){
        Book book = bookRepo.findByIdBook(bookId);
        int bought_count = book.getBought_count();
        int cartCount = book.getCartCount();
        int wishlistCount = book.getWishlistCount();
        int totalCount = book.getTotalCount();
        if (totalCount == 0) {
            return 0;
        }
        double popularity = (bought_count * 2 + cartCount + wishlistCount) / (double) totalCount;
        return popularity;
    }
}
