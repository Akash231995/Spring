package com.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mvc.model.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Response> handleConflict(RuntimeException ex) {
		return ResponseEntity.ok(new Response(HttpStatus.PRECONDITION_FAILED, ex.getMessage()));
	}
}
