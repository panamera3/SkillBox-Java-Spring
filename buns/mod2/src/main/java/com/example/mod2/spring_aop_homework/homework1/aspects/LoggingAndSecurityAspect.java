package com.example.mod2.spring_aop_homework.homework1.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {
    /*
    @Pointcut("execution(* com.example.mod2.spring_aop_homework.homework1.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary(){}

    @Pointcut("execution(public void com.example.mod2.spring_aop_homework.homework1.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary(){}

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExceptReturnMagazineFromUniLibrary(){}

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsExceptReturnMagazineAdvice(){
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing log #99");
    }
     */

    /*
    @Pointcut("execution(* com.example.mod2.spring_aop_homework.homework1.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary(){}

    @Pointcut("execution(* com.example.mod2.spring_aop_homework.homework1.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary(){}

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary(){}

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing log #1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: writing log #2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: writing log #3");
    }
    */

    //@Before("execution(public void com.example.mod2.spring_aop_homework.homework1.UniLibrary.getBook())")
    //@Before("execution(* *(..))")
    //@Before("execution(public void *(*))")
    //@Before("execution(public void *(..))")
    //@Before("execution(public void getBook(com.example.mod2.spring_aop_homework.homework1.Book))")
}
