package com.example.mod1.spring_homework.homework2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        /*
        //Dog myDog = context.getBean("dogBean", Dog.class);
        Dog myDog = context.getBean("dog", Dog.class);
        myDog.say();
         */

        Person person = context.getBean("personBean", Person.class);
        person.callPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();
    }
}
