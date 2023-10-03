package com.example.mod2.spring_aop_homework.homework1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibraryBean", UniLibrary.class);
        Book book = context.getBean("bookBean", Book.class);

        uniLibrary.getBook();
        uniLibrary.getMagazine();
        uniLibrary.returnBook();
        uniLibrary.returnMagazine();
        uniLibrary.addBook("Lena", book);
        uniLibrary.addMagazine();

/*
        SchoolLibrary schoolLibrary = context.getBean("schoolLibraryBean", SchoolLibrary.class);
        schoolLibrary.getBook();
*/



        context.close();
    }
}
