package com.example.mod1.spring_homework.homework2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog firstDog = context.getBean("dogBean", Dog.class);
        firstDog.say();
        /*
        Dog secondDog = context.getBean("dogBean", Dog.class);

        System.out.println("Переменные ссылаются на один и тот же объект: " + (firstDog == secondDog));
        System.out.println(firstDog);
        System.out.println(secondDog);
         */
        context.close();
    }
}
