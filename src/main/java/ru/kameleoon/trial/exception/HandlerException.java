package ru.kameleoon.trial.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HandlerException extends RuntimeException {
	private final ErrorCode code;
	private final String message;
}
