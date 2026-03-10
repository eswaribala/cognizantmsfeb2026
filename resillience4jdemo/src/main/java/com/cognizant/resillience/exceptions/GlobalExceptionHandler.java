package com.cognizant.resillience.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.resillience.dtos.GenericResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IgnoreException.class)
	public ResponseEntity<GenericResponse<String>> handleIgnoreException(IgnoreException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new GenericResponse<>(ex.getMessage()));
	}

	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<GenericResponse<String>> handleJsonProcessingException(JsonProcessingException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new GenericResponse<>(ex.getMessage()));
	}
}
