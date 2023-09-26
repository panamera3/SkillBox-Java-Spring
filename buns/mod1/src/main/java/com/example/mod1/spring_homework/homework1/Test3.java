package com.example.mod1.spring_homework.homework1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");

        Person person = context.getBean("myPerson", Person.class);
        person.callPet();

        System.out.println("Фамилия: " + person.getSurname());
        System.out.println("Возраст: " + person.getAge());

        context.close();
    }
}
