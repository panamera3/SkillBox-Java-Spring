package com.example.mod2.spring_aop_homework.homework2;

import com.example.mod2.spring_aop_homework.homework2.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary library = context.getBean("uniLibraryBean", UniLibrary.class);
        String bookName = library.returnBook();
        System.out.println("В библиотеку университета вернули книгу " + bookName);

        context.close();
        System.out.println("Method main ends");
    }
}
