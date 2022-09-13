package com.springboot.demo.mycoolapp.rest;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryRestExceptionHandler {

	
	
	@ExceptionHandler
	public ResponseEntity<CategoryErrorResponse> handleException(CategoryNotFoundException exc) {
		
		
		
		CategoryErrorResponse error = new CategoryErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler
	public ResponseEntity<CategoryErrorResponse> handleException(Exception exc) {
		
		// create CategoryErrorResponse
		
		CategoryErrorResponse error = new CategoryErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}





