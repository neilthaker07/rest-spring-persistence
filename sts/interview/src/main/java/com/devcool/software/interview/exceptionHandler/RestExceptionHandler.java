package com.devcool.software.interview.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devcool.software.interview.exception.PlayerNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {PlayerNotFoundException.class})
    @ResponseBody
    public ResponseEntity<Object> handlePlayerNotFoundException(PlayerNotFoundException ex, 
    		WebRequest request) {
    	
    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	

}
