package com.ambiasystems.aria.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException exception) {
		log.error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> notFoundException(EntityNotFoundException exception) {
		log.error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

	 @ExceptionHandler(HandlerMethodValidationException.class)
	    public ResponseEntity<String> invalidEmailFormatException(HandlerMethodValidationException exception) {
	        String errorMessage = "Invalid request parameter / path variable : " + exception.getMessage();
	        log.error(exception.getMessage());
	        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	    }
	 
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception exception) {
    	log.error(exception.getMessage());
        return new ResponseEntity<>("An unexpected error occurred: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
