package com.example.mod2.spring_aop_homework.homework1.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30)
public class ExceptionHandlingAspect {
    @Before("com.example.mod2.spring_aop_homework.homework1.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddExceptionHandlingAdvice() {
        System.out.println("3. beforeGetExceptionHandlingAdvice: ловим/обрабатываем исключения при попытке получить книгу/журнал");
        System.out.println("------------------------------------------");
    }
}
