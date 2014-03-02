package com.pets.dog.aop.advice;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class PetDogsAdvice {
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(PetDogsAdvice.class);
	
	@Before("execution(*  com.pets.dog.dao.jdbc.*.*(..))")
	public void addStatementBefore(JoinPoint joinPoint) {
		logger.debug("Good morning  : " + joinPoint.getSignature().getName());
		logger.debug("Method parameters : "+Arrays.asList(joinPoint.getArgs()));
	}

}
