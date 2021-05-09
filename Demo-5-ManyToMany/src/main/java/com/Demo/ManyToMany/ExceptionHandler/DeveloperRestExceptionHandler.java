package com.Demo.ManyToMany.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Demo.ManyToMany.customException.DeveloperNotFoundException;
import com.Demo.ManyToMany.errorResponse.DeveloperErrorResponse;

@ControllerAdvice
public class DeveloperRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> handleException(DeveloperNotFoundException exc) {
		DeveloperErrorResponse error = new DeveloperErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<?> handleException(NumberFormatException exc) {
		DeveloperErrorResponse error = new DeveloperErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Please provide valid value");
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler
//	public ResponseEntity<?> handleException(Exception exc) {
//		DeveloperErrorResponse error = new DeveloperErrorResponse();
//
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}
}
