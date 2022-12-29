package com.example.quiz_system_demo.admin_hibernate.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {

    @Pointcut("within(com.example.quiz_system_demo.admin_hibernate.controller.*)")
    public void inControllerLayer(){}

}
