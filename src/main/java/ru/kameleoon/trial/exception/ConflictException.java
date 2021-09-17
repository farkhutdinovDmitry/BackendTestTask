package ru.kameleoon.trial.exception;

public class ConflictException extends HandlerException {
	public ConflictException(String message) {
		super(ErrorCode.CONFLICT, message);
	}
}
