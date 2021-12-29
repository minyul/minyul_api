package com.minyul.api.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ExceptionDto {

	private final int status;
	private final String message;
	private final String exceptionType;
	private final LocalDateTime time = LocalDateTime.now();

	@Builder
	public ExceptionDto(int status, String message, String exceptionType) {
		this.status = status;
		this.message = message;
		this.exceptionType = exceptionType;
	}

	public static ExceptionDto of(HttpStatus status, Exception exception) {
		return ExceptionDto.builder()
						.status(status.value())
						.message(exception.getMessage())
						.exceptionType(exception.getClass().getSimpleName())
						.build();
	}
}
