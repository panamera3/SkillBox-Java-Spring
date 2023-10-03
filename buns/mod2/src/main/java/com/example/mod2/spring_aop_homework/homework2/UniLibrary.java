package com.example.mod2.spring_aop_homework.homework2;

import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary extends AbstractLibrary {
    public String returnBook(){
        int a = 10/0;
        System.out.println("Возвращаем книгу в UniLibrary.");
        return "1984";
    }
}
