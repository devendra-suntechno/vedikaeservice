package com.vedika.functionhall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
	
@ExceptionHandler()
public ResponseEntity<Exceptions> mapException(Exception ex)throws Exception{
	Exceptions error =new Exceptions(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
	return new ResponseEntity<Exceptions>(error,HttpStatus.BAD_REQUEST);
	
}
}
