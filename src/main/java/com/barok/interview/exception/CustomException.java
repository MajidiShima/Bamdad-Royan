package com.barok.interview.exception;


import lombok.Data;

import java.util.function.Supplier;

@Data
public class CustomException extends RuntimeException implements Supplier<CustomException> {
	private String message;

	@Override
	public CustomException get() {
		return this;
	}

	public CustomException(String message) {
		this.message = message;
	}
}
