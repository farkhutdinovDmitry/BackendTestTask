package ru.kameleoon.trial.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
	BAD_REQUEST, NOT_FOUND, CONFLICT;

	public HttpStatus toHttpStatus() {
		switch (this) {
			case CONFLICT:
				return HttpStatus.CONFLICT;
			case NOT_FOUND:
				return HttpStatus.NOT_FOUND;
			case BAD_REQUEST:
				return HttpStatus.BAD_REQUEST;
			default:
				return HttpStatus.NOT_IMPLEMENTED;
		}
	}
}
