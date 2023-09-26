package com.example.mod1.spring_homework.homework1;

public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }

    /*
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    */

    public void init(){
        System.out.println("Class God: init() method");
    }

    public void destroy(){
        System.out.println("Class God: destroy() method");
    }

    @Override
    public void say() {
        System.out.println("Bark!");
    }
}
