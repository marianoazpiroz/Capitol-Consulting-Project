package com.capitol.challenge.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogginAspectException {

	private static final String ERROR_MESSAGE = "SE A PRODUCIDO UN ERROR INESPERADO";
	
	 @AfterThrowing(value ="execution(* com.capitol.challenge.service.PriceService.buscarRegistroPersonalizado(..))", throwing="ex")
	    public void logAfterThrowing(JoinPoint jointPoint, Exception ex) {

	        System.out.println(ERROR_MESSAGE);
	        System.out.println(jointPoint.getSignature());
	        System.out.println(ex.getMessage());
	        
	        
	    }
	    
}
