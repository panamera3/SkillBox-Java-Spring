package com.example.mod2.spring_aop_homework.homework2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        Object targetMethodResult = null;

        long start = System.nanoTime();
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("aroundReturnBookLoggingAdvice: исключение " + ex + " было залогировано.");
            //targetMethodResult = "Unknown book name";
            throw ex;
        }
        long end = System.nanoTime();

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        System.out.println("aroundReturnBookLoggingAdvice: method returnBook выполнил работу за " + (end - start) + " наносекунд.");
        return targetMethodResult;
    }

}
