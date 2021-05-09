package com.Demo.OneToOneUni.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Demo.OneToOneUni.customException.EmployeeNotFoundException;
import com.Demo.OneToOneUni.errorResponse.EmployeeErrorResponse;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> handleException(EmployeeNotFoundException exc) {
		EmployeeErrorResponse error = new EmployeeErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<?> handleException(NumberFormatException exc) {
		EmployeeErrorResponse error = new EmployeeErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Please provide valid value");
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<?> handleException(Exception exc) {
		EmployeeErrorResponse error = new EmployeeErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
