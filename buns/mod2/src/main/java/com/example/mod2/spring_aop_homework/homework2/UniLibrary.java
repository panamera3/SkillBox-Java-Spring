package com.example.mod2.spring_aop_homework.homework2;

import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary extends AbstractLibrary {

    //@Override
    public void getBook(){
        System.out.println("Берём книгу из UniLibrary.");
        System.out.println("------------------------------------------");
    }

    public void getMagazine(){
        System.out.println("Берём журнал из UniLibrary.");
        System.out.println("------------------------------------------");
    }

    public String returnBook(){
        int a = 10/0;
        System.out.println("Возвращаем книгу в UniLibrary.");
        return "1984";
    }

    public void returnMagazine(){
        System.out.println("Возвращаем журнал в UniLibrary.");
        System.out.println("------------------------------------------");
    }

    public void addBook(String person_name, Book book){
        System.out.println("Добавляем книгу в UniLibrary");
        System.out.println("------------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Добавлеяем журнал в UniLibrary");
        System.out.println("------------------------------------------");
    }
}
