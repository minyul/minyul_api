package com.minyul.api.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {

	@ExceptionHandler(PostTestException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionDto postTest(PostTestException exception) {
		return ExceptionDto.of(HttpStatus.INTERNAL_SERVER_ERROR, exception);
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionDto runtime(RuntimeException exception) {
		return ExceptionDto.of(HttpStatus.INTERNAL_SERVER_ERROR, exception);
	}
}
