package com.hr.app.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hr.app.entity.Candidate;
@ControllerAdvice
public class CandidateRestExceptionHandler {

	
	
	@ExceptionHandler
	public ResponseEntity<CandidateErrorResponse> handleException(CandidateNotFoundException exc) {
		
		// create CustomerErrorResponse
		
		CandidateErrorResponse error = new CandidateErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<CandidateErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		CandidateErrorResponse error = new CandidateErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
