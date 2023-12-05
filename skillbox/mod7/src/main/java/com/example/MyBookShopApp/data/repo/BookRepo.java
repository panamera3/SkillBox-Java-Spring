package com.example.MyBookShopApp.data.repo;

import com.example.MyBookShopApp.data.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {

    List<Book> findBooksByAuthor_FirstName(String name);

    @Query("from Book")
    List<Book> customFindAllBooks();

    //NEW BOOK REST REPOSITORY

    List<Book> findBooksByAuthorFirstNameContaining(String authorsFirstName);

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceBetween(Integer min, Integer max);

    List<Book> findBooksByPriceIs(Integer price);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findBookByTitleContaining(String bookTitle, Pageable nextPage);

    @Query(value = "SELECT * FROM books WHERE b.pubDate BETWEEN :from AND :to", nativeQuery = true)
    Page<Book> findBooksByDateBetween(@Param("from") Date from, @Param("to") Date to, Pageable pageable);

    @Query(value = "SELECT * FROM books WHERE id = :id", nativeQuery = true)
    Book findByIdBook(@Param("id") Integer id);

    @Query(value = "SELECT * FROM books WHERE tag_id = :tag_id", nativeQuery = true)
    Page<Book> findByTagId(@Param("tag_id") Integer tag_id, Pageable nextPage);

    @Query(value = "SELECT * FROM books WHERE author_id = :author_id", nativeQuery = true)
    Page<Book> findByAuthorId(@Param("author_id") Integer author_id, Pageable nextPage);

    Book findBookBySlug(String slug);
}
