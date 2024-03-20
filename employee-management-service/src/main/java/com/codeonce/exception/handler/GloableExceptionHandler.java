package com.codeonce.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codeonce.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class GloableExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmpNotFoundEx(EmployeeNotFoundException empNFE){
		return new ResponseEntity<>(empNFE.getMessage(), HttpStatus.NOT_FOUND);
	}
}
