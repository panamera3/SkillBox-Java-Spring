package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rownum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        });

        return authors.stream().collect(Collectors.groupingBy((Author a) -> {
            return a.getLastName().substring(0, 1);
        }));
    }

    public List<Author> getAuthorsList() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rownum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public List<BookAuthors> replacedAuthorsInBooks(List<Book> books) {
        List<Author> authors = getAuthorsList();

        List<BookAuthors> result = books.stream()
                .map(book -> {
                    BookAuthors newBook = new BookAuthors();
                    int authorId = book.getAuthorId();
                    String authorName = authors.stream()
                            .filter(author -> author.getId() == authorId)
                            .map(Author::getFullName)
                            .findFirst()
                            .orElse(null);
                    newBook.setAuthorName(authorName);
                    newBook.setPrice(book.getPrice());
                    newBook.setTitle(book.getTitle());
                    newBook.setId(book.getId());
                    newBook.setPriceOld(book.getPriceOld());
                    return newBook;
                }).collect(Collectors.toList());

        return new ArrayList<>(result);
    }
}
