package com.example.mod1.spring_homework.homework1;

import javax.xml.transform.sax.SAXResult;

public class Person {
    public Person() {
        System.out.println("Person bean is created");
    }

    /*
        public Person(Pet pet) {
            System.out.println("Person bean is created");
            setPet(pet);
        }
    */

    private Pet pet;
    private String surname;
    private int age;


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
