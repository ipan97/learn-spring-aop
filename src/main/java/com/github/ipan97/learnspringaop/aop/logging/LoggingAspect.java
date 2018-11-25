package com.github.ipan97.learnspringaop.aop.logging;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * [DOCUMENTATION HERE].
 *
 * @author Ipan Taufik Rahman
 */
@Aspect
@Slf4j
public class LoggingAspect {

	@Pointcut("within(@org.springframework.stereotype.Repository *)" +
			"within(@org.springframework.streotype.Service *)" +
			"within(@org.springframeowrk.web.bind.annotation.RestController *)")
	public void springBeanPointcut() {
	}

	@Pointcut("within(com.github.ipan97.learnspringaop.repository..*)" +
			"within(com.github.ipan97.learnspringaop.service..*)" +
			"whithin(com.github.ipan97.learnspringaop.web.rest..*)")
	public void applicationPackagePointcut() {
	}

	@AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	}
	
	@Around("applicationPackagePointcut() && springBeanPointcut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if (log.isDebugEnabled()) {
			log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		}
		try {
			Object result = joinPoint.proceed();
			if (log.isDebugEnabled()) {
				log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
						joinPoint.getSignature().getName(), result);
			}
			return result;
		}
		catch (IllegalArgumentException e) {
			log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
					joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

			throw e;
		}
	}
}
