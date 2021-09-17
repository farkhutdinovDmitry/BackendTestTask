package ru.kameleoon.trial.exception;

public class BadInputException extends HandlerException {
	public BadInputException(String message) {
		super(ErrorCode.BAD_REQUEST, message);
	}
}
