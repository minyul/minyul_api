package com.minyul.api.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class LogAspect {

	/**
	 *  @Around()
	 *  @AfterThrowing
	 *  @AfterReturning
	 *  @Before
	 *  @After
	 *  만약, 갖고오는 메소드만 하고 싶다면, PostService.retrieve*(..)
	 */

	@Before("execution(* com.minyul.api.facade.service.PostService.*(..))")
	public void beforeLog(JoinPoint joinPoint) {
		log.info("Method Name : {}", joinPoint.getSignature().getName());
		log.info("AOP TEST : {}", LocalDateTime.now());
	}

	@After("execution(* com.minyul.api.facade.service.PostService.*(..))")
	public void afterLog(JoinPoint joinPoint) {
		log.info("Method Name : {}", joinPoint.getSignature().getName());
		log.info("AOP TEST : {}", LocalDateTime.now());
	}
}
