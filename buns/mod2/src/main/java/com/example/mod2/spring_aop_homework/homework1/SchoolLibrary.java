package com.example.mod2.spring_aop_homework.homework1;

import org.springframework.stereotype.Component;

@Component("schoolLibraryBean")
public class SchoolLibrary extends AbstractLibrary {

    //@Override
    public void getBook() {
        System.out.println("Берём книгу из SchoolLibrary.");
    }
}
