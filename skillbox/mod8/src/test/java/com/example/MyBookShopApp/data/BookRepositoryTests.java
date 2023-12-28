package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.repo.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class BookRepositoryTests {

    private final BookRepo bookRepository;

    @Autowired
    public BookRepositoryTests(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    void findBooksByAuthor_FirstName() {
        String token = "Aldwin";
        List<Book> bookListByAuthorFirstName = bookRepository.findBooksByAuthor_FirstName(token);

        assertNotNull(bookListByAuthorFirstName);
        assertFalse(bookListByAuthorFirstName.isEmpty());

        for (Book book : bookListByAuthorFirstName) {
            Logger.getLogger(this.getClass().getSimpleName()).info(book.toString());
            assertThat(book.getAuthor().getFirstName()).contains(token);
        }
    }

    @Test
    void findBooksByTitleContaining() {
        String token = "Tape";
        List<Book> bookListByTitleContaining = bookRepository.findBooksByTitleContaining(token);
        assertNotNull(bookListByTitleContaining);
        assertFalse(bookListByTitleContaining.isEmpty());

        for (Book book : bookListByTitleContaining) {
            Logger.getLogger(this.getClass().getSimpleName()).info(book.toString());
            assertThat(book.getTitle()).contains(token);
        }
    }

    @Test
    void getBestsellers() {
        List<Book> bestSellersBooks = bookRepository.getBestsellers();
        assertNotNull(bestSellersBooks);
        assertFalse(bestSellersBooks.isEmpty());

        assertThat(bestSellersBooks.size()).isGreaterThan(1);
    }
}