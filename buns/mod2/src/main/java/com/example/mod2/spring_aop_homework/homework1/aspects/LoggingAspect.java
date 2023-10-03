package com.example.mod2.spring_aop_homework.homework1.aspects;

import com.example.mod2.spring_aop_homework.homework1.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

    @Before("com.example.mod2.spring_aop_homework.homework1.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Инфа о книге: название - " + myBook.getName() + ", автор - " +
                            myBook.getAuthor() + ", год издания - " + myBook.getYearOfPublication());
                }
                else if(obj instanceof String){
                    System.out.println("Книгу в библиотеку добавил " + obj);
                }
            }
        }


        System.out.println("1. beforeGetLoggingAdvice: логирование попытки получить книгу/журнал.");
        System.out.println("------------------------------------------");
    }

    @Before("execution(* returnBook())")

    public void beforeReturnBookAdvice() {
        System.out.println("1. beforeReturnBookAdvice: попытка вернуть что-то.");
        System.out.println("------------------------------------------");
    }



}
