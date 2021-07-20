package com.mvc.exception;

public class InsertFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsertFailedException() {
		super();
	}

	public InsertFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsertFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsertFailedException(String message) {
		super(message);
	}

	public InsertFailedException(Throwable cause) {
		super(cause);
	}

}
