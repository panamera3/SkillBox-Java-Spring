package com.example.mod1.spring_homework.homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    //@Autowired
    //@Qualifier("dogBean")
    private Pet pet;
    //@Value("${person.surname}")
    private String surname;
    //@Value("${person.age}")
    private int age;

    /*
    public Person() {
        System.out.println("Person bean is created");
    }
    */

    @Autowired
    public Person(@Qualifier("dogBean") Pet pet) {
        System.out.println("Person bean is created");
        setPet(pet);
    }

    //@Autowired
    //@Qualifier("dogBean")
    public void setPet(Pet pet) {
        System.out.println("Setter for pet.");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Setter for surname.");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter for age.");
        this.age = age;
    }


    public void callPet() {
        System.out.println("Come here, my pet!");
        pet.say();
    }
}
