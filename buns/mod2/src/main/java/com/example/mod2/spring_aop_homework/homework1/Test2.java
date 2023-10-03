package com.example.mod2.spring_aop_homework.homework1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        try {
            List<Student> students = university.getStudents();
            System.out.println(students);
        } catch (Exception ex) {
            System.out.println("Было поймано исключение: " + ex);
        }


        context.close();
    }
}
