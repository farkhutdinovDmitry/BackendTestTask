package ru.kameleoon.trial.exception;

public class NotFoundException extends HandlerException {
	public NotFoundException() {
		super(ErrorCode.NOT_FOUND, "Resource not found");
	}
}
