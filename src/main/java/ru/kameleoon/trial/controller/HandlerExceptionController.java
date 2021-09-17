package ru.kameleoon.trial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kameleoon.trial.exception.HandlerException;

@RestControllerAdvice
public class HandlerExceptionController {
	@ExceptionHandler(HandlerException.class)
	public ResponseEntity<String> handleException(HandlerException ex) {
		return ResponseEntity.status(ex.getCode().toHttpStatus()).body(ex.getMessage());
	}
}
