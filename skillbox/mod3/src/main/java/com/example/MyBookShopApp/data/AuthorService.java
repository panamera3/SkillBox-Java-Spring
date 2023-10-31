package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;

@Service
public class AuthorService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<Character, List<String>> getAuthorsData(){
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rownum)->{
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("firstName"));
            author.setLastName(rs.getString("lastName"));
            return author;
        });

        Map<Character, List<String>> lastNameDict = new HashMap<>();

        for (Author author : authors) {
            char firstLetter = author.getLastName().charAt(0);
            if (!lastNameDict.containsKey(firstLetter)) {
                lastNameDict.put(firstLetter, new ArrayList<>());
            }
            lastNameDict.get(firstLetter).add(author.getLastName() + " " + author.getFirstName());
        }

        return lastNameDict;
    }
}
