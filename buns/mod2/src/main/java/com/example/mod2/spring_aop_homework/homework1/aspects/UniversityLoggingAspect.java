package com.example.mod2.spring_aop_homework.homework1.aspects;

import com.example.mod2.spring_aop_homework.homework1.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов перед методом getStudents.");
    }

    //Changing surnameName and avgGrade for first student in List of students
    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
        Student firstStudent = students.get(0);
        String surnameName = firstStudent.getSurnameName();
        surnameName = "Mr./Ms. " + surnameName;
        firstStudent.setSurnameName(surnameName);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade += 0.1;
        firstStudent.setAvgGrade(avgGrade);



        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка студентов после работы метода getStudents.");
    }

    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
        System.out.println("afterThrowingGetStudentsLoggingAdvice: log of throwing - " + exception);
    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: логируем нормальное окончание работы метода или выброс исключения.");
    }

}
