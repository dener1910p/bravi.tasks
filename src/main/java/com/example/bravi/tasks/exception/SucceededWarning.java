package com.example.bravi.tasks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class SucceededWarning extends RuntimeException {
	public SucceededWarning(String message) {
		super(message);
	}
}
