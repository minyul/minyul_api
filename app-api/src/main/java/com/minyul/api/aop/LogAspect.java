package com.minyul.api.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class LogAspect {

	@Around("execution(* com.minyul.api.facade.service.PostService.*(..))")
	public void testLog() {
		log.info("AOP TEST : {}", LocalDateTime.now());
	}
}
