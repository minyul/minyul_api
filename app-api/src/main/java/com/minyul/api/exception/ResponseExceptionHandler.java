package com.minyul.api.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {

	/**
	 * 해당 리소스가 없는 경우
	 * 1. 알려지지 않는 URL
	 * 2. 해당 리소스가 존재하지 않는 경우
	 * @author : Minyul
	 */
	@ExceptionHandler(PostNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionDto postNotFound(PostNotFoundException exception) {
		return ExceptionDto.of(HttpStatus.INTERNAL_SERVER_ERROR, exception);
	}

	/**
	 * External Exception ( 외부 API ) : Todo 우선 404 로 했는데 흠.............. 고민 중
	 */
	@ExceptionHandler(ExternalException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionDto external(ExternalException exception) {
		return ExceptionDto.of(HttpStatus.NOT_FOUND, exception);
	}


	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionDto runtime(RuntimeException exception) {
		return ExceptionDto.of(HttpStatus.INTERNAL_SERVER_ERROR, exception);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionDto validation(MethodArgumentNotValidException validationException) {

		/**
		 * 결과값이 조금 길다. MethodArgumentNotValidException , .getBindingResult().toString()
		 * 으로 줄일 수 있는데. 리팩토링이 필요할 듯.
		 */

		return ExceptionDto.of(HttpStatus.BAD_REQUEST, validationException);
	}
}
