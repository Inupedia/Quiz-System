package com.example.quiz_system_demo.admin_hibernate.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning(value = "com.example.quiz_system_demo.admin_hibernate.aop.PointCuts.inControllerLayer()", returning = "res")
    public void logReturnObject(Object res){
        logger.info("From LoggingAspect.logReturnObject in controller: " + "user found: " + res.toString());
    }

    @AfterThrowing(value = "com.example.quiz_system_demo.admin_hibernate.aop.PointCuts.inControllerLayer()", throwing = "ex")
    public void logThrownException(Throwable ex){
        logger.error("From LoggingAspect.logThrownException in controller: " + ex.getMessage());
    }
}
