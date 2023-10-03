package com.example.mod2.spring_aop_homework.homework2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bookBean")
public class Book {
    @Value("1984")
    private String name;

    @Value("Джордж Оруэлл")
    private String author;

    @Value("1700")
    private int yearOfPublication;

    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public String getYearOfPublication(){
        return String.valueOf(yearOfPublication);
    }
}
