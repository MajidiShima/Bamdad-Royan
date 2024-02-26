package com.barok.interview.controller;

import com.barok.interview.exception.CustomException;
import com.barok.interview.exception.CustomResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController<T> {
	protected static final Logger logger = LogManager.getLogger(BaseController.class);

	protected ResponseEntity<CustomResponse> failure(Exception e) {
		CustomResponse expenseRestResponse = new CustomResponse<>();
		CustomException ce;
		if (e instanceof CustomException) {
			ce = (CustomException) e;
			logger.error(ce);
		} else {
			e.printStackTrace();
			logger.error(e.getStackTrace());
			ce = new CustomException("failure in application");
		}
		expenseRestResponse.setErrorMessage(ce.getMessage());
		return new ResponseEntity<>(expenseRestResponse, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	protected ResponseEntity<CustomResponse<T>> success(T result) {
		CustomResponse<T> expenseRestResponse = new CustomResponse<>();
		expenseRestResponse.setData(result);
		return new ResponseEntity(result, HttpStatus.OK);
	}
}


