package com.example.mod1.spring_homework.homework1;

public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow!");
    }
}
