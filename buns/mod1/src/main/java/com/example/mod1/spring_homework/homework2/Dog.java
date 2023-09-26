package com.example.mod1.spring_homework.homework2;

import org.springframework.stereotype.Component;

//@Component
@Component("dogBean")
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bark!");
    }
}
