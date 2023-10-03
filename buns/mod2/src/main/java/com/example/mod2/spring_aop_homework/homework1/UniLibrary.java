package com.example.mod2.spring_aop_homework.homework1;

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

    public void returnBook(){
        System.out.println("Возвращаем книгу в UniLibrary.");
        System.out.println("------------------------------------------");
    }

    public void returnMagazine(){
        System.out.println("Возвращаем журнал в UniLibrary.");
        System.out.println("------------------------------------------");
    }

    public void addBook(String person_name, Book book){
        System.out.println("Добавлеяем книгу в UniLibrary");
        System.out.println("------------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Добавлеяем журнал в UniLibrary");
        System.out.println("------------------------------------------");
    }
}
