package com.barok.interview.exception;

import lombok.Data;

@Data
public class CustomResponse<T> {
	private String errorMessage;
	private T data;
}
