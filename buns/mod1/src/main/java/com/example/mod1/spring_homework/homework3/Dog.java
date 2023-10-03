package com.example.mod1.spring_homework.homework3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Component("dogBean")
@Scope("singleton")
//@Scope("prototype")
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bark!");
    }
}
