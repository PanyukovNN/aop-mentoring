package ru.panyukovnn.aopmentoring.aspectspring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class SpringAspect {

    private static final Logger log = LoggerFactory.getLogger(SpringAspect.class);

    @Pointcut("@within(org.springframework.stereotype.Component)")
    public void isComponentMethod() {
    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void isServiceMethod() {
    }

    @Before("isComponentMethod() || isServiceMethod()")
    public void beforeComponentOrServiceMethod(JoinPoint joinPoint) {
        log.info("@Before Вызван метод: {}. класса (@Component или @Service): {}",
            joinPoint.getSignature().getName(),
            joinPoint.getTarget().getClass().getSimpleName());
    }

    @After("target(ru.panyukovnn.aopmentoring.service.DemoService)")
    public void afterServiceMethod(JoinPoint joinPoint) {
        log.info("@After Отправляем событие аудита после вызова метода: {}, класса: {}",
            joinPoint.getSignature().getName(),
            joinPoint.getTarget().getClass().getSimpleName());
    }

    @AfterReturning(value = "bean(demoComponentImpl)", returning = "result")
    public void afterControllerMethodReturning(JoinPoint joinPoint, Object result) {
        log.info("@AfterReturning Вызван метод: {}, класса: {}, результат вызова: {}",
            joinPoint.getSignature().getName(),
            joinPoint.getTarget().getClass().getSimpleName(),
            result);
    }

    @Around("@annotation(ru.panyukovnn.aopmentoring.annotation.Log)")
    public Object aroundLogExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Начало spring @Around по аннотации Log");

        try {
            return proceedingJoinPoint.proceed();
        } finally {
            log.info("Конец spring @Around по аннотации Log");
        }
    }
}
