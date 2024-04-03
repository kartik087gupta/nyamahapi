package com.Nyamah.apis.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<Map<String, String>>
	 * handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	 * 
	 * Map<String,String> resp = new HashMap<>();
	 * 
	 * ex.getBindingResult().getAllErrors().forEach(error->{ String fieldName =
	 * ((FieldError)error).getField(); String defaultMessage =
	 * error.getDefaultMessage(); resp.put(fieldName, defaultMessage); });
	 * 
	 * return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST); }
	 */
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, Object> errors = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String errorMessage = error.getDefaultMessage();
			sb.append(errorMessage + ", ");
		});
		errors.put("message", sb.substring(0, sb.length() - 2));
		errors.put("status", "error");
		errors.put("data", null);
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}
