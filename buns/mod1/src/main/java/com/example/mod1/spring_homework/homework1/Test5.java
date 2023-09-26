package com.example.mod1.spring_homework.homework1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog firstDog = context.getBean("myPet", Dog.class);
        firstDog.say();
        Dog secondDog = context.getBean("myPet", Dog.class);
        secondDog.say();

        context.close();
    }
}
