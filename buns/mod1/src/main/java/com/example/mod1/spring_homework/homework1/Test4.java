package com.example.mod1.spring_homework.homework1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        /*
        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.setName("First");
        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.setName("Second");

        System.out.println("Один и тот же объект? " + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);
        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());
         */
        context.close();
    }
}
