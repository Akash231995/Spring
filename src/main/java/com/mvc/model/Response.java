package com.mvc.model;

import org.springframework.http.HttpStatus;

public class Response {
	private HttpStatus status;
	private String message;

	public Response(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getCode() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
