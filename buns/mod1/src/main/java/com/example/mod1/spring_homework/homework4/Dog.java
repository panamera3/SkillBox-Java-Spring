package com.example.mod1.spring_homework.homework4;

import org.springframework.context.annotation.Scope;

@Scope("singleton")
//@Scope("prototype")
public class  Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bark!");
    }

    /*
    @PostConstruct
    public void init(){
        System.out.println("Class Dog: init() method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Class Dog: destroy() method");
    }
     */
}
