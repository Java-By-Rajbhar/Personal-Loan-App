package com.hcl.rest.api.exceptionHandling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GbobalExceptionHandler  {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllException(Exception ex,WebRequest request)
	{
		ErrorResponse response  =  new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
