package com.example.mod1.spring_homework.homework4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Pet dog1 = context.getBean("dogBean", Pet.class);
        Pet dog2 = context.getBean("dogBean", Pet.class);
        //dog.say();

        Person person1 = context.getBean("personBean", Person.class);
        //Person person2 = context.getBean("personBean", Person.class);
        person1.callPet();
        System.out.println("Фамилия: " + person1.getSurname());
        System.out.println("Возраст: " + person1.getAge());

        context.close();
    }
}
