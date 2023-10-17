package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;
    private final Logger logger = Logger.getLogger(BookService.class);


    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(String bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    public boolean removeBooksByRegex(String queryRegex) {
        String[] parts = queryRegex.split("=");
        String fieldName = parts[0];
        String value = parts[1];
        ArrayList<Boolean> hadDeleted = new ArrayList<Boolean>();

        for (Book book : bookRepo.retreiveAll()) {
            switch (fieldName) {
                case "author":
                    if (book.getAuthor().equals(value)) {
                        bookRepo.removeItemById(book.getId());
                        hadDeleted.add(true);
                    }
                    break;

                case "title":
                    if (book.getTitle().equals(value)) {
                        bookRepo.removeItemById(book.getId());
                        hadDeleted.add(true);
                    }
                    break;

                case "size":
                    if (book.getSize() == Integer.parseInt(value)) {
                        bookRepo.removeItemById(book.getId());
                        hadDeleted.add(true);
                    }
                    break;
            }
        }

        return hadDeleted.contains(true);
    }


    private void defaultInit() {
        logger.info("default INIT in book service");
    }

    private void defaultDestroy() {
        logger.info("default DESTROY in book service");
    }
}
