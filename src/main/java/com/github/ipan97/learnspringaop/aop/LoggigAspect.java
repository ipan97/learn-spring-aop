package com.github.ipan97.learnspringaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ipan Taupik Rahman
 */
@Component
@Aspect
public class LoggigAspect {

    private static Logger logger = Logger.getLogger(LoggigAspect.class.getName());

    private ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("[yyyy-mm-dd hh:mm:ss:SSS]");
        }
    };

    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void repositoryMethods() {
    }

    @Pointcut("@annotation(com.github.ipan97.learnspringaop.aop.annotations.Loggable)")
    public void loggableMethods() {
    }

    @Pointcut("@args(com.github.ipan97.learnspringaop.aop.annotations.Entity)")
    public void methodsAcceptingEntities() {
    }

    @Before("repositoryMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info(sdf.get().format(new Date()) + methodName);
    }

    @Before("loggableMethods()")
    public void logMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Executing method: " + methodName);
    }

    @Before("methodsAcceptingEntities()")
    public void logMethodAcceptionEntityAnnotatedBean(JoinPoint jp) {
        logger.info("Accepting beans with @Entity annotation: " + jp.getArgs()[0]);
    }
}
