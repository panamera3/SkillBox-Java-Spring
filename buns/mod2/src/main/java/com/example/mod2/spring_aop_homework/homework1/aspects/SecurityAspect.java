package com.example.mod2.spring_aop_homework.homework1.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {
    @Before("com.example.mod2.spring_aop_homework.homework1.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddSecurityAdvice(){
        System.out.println("2. beforeGetSecurityAdvice: проверка прав на получение книги/журнала.");
        System.out.println("------------------------------------------");
    }
}
