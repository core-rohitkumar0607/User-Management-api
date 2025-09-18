package com.example.demo.exception;

	import org.springframework.http.*;
	import org.springframework.web.bind.MethodArgumentNotValidException;
	import org.springframework.web.bind.annotation.*;
	import java.util.*;

	@RestControllerAdvice
	public class GlobalExceptionHandler {

	    // Validation Errors
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error ->
	            errors.put(error.getField(), error.getDefaultMessage())
	        );
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }

	    // Resource Not Found
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<Map<String, String>> handleResourceNotFound(ResourceNotFoundException ex) {
	        Map<String, String> error = new HashMap<>();
	        error.put("error", ex.getMessage());
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }

	    // Other Exceptions
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
	        Map<String, String> error = new HashMap<>();
	        error.put("error", ex.getMessage());
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

