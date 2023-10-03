package com.example.mod2.spring_aop_homework.homework1.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    /*
    @Pointcut("execution(* get*())")
    public void allGetMethods(){}
     */

    @Pointcut("execution(* abc*(..))")
    public void allAddMethods(){}
}
