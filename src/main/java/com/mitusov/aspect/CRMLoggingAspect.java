package com.mitusov.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private static Logger logger = Logger
            .getLogger(CRMLoggingAspect.class.getName());

    @Pointcut("execution(* com.mitusov.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.mitusov.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.mitusov.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        logger.info("==>> in @Before advice calling method " + joinPoint
                .getSignature()
                .toShortString());

        Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .forEach(logger::info);
    }

    @AfterReturning(pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("==>> in @AfterReturning advice calling method " + joinPoint
                .getSignature()
                .toShortString());

        logger.info("==>> result " + result);

    }
}
