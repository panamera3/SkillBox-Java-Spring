package com.example.mod2.spring_aop_homework.homework1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Elena Pyanova", 3, 9.9);
        Student st2 = new Student("Ivan Ivanov", 1, 5.0);
        Student st3 = new Student("Petr Petrov", 2, 7.2);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("Info from method getStudents: ");
        System.out.println(students);

        return students;
    }

}
