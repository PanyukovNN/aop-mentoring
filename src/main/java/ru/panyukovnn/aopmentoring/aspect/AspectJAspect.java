package ru.panyukovnn.aopmentoring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectJAspect {

    @Pointcut("@annotation(ru.panyukovnn.aopmentoring.annotation.Log) && execution(* *(..))")
    public void annotatedWithLog() {
    }

    @Around("annotatedWithLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Начало aspectj @Around по аннотации Log");

        try {
            return pjp.proceed();
        } finally {
            log.info("Конец aspectj @Around по аннотации Log");
        }
    }
}
