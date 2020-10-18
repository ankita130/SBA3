package com.iiht.evaluation.interviewtracker.exception;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.iiht.evaluation.interviewtracker.exception.model.ExceptionResponse;

@ControllerAdvice
public class GlobalHandler{
	
	    // Exception Handler Method for User not Found Exception
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<ExceptionResponse> handler(UserNotFoundException ex) {
			ExceptionResponse exResponse =
					new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),ex.getMessage());
			ResponseEntity<ExceptionResponse> response = 
					new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
			return response;
		}
		
		 // Exception Handler Method for Interview not Found Exception
		@ExceptionHandler(InterviewNotFoundException.class)
		public ResponseEntity<ExceptionResponse> handler(InterviewNotFoundException ex) {
			
			ExceptionResponse exResponse =
					new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),ex.getMessage());
			ResponseEntity<ExceptionResponse> response = 
					new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
			return response;
		}
		
		// Exception Handler Method for request body is not proper 
		@ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ExceptionResponse> handler(MethodArgumentNotValidException ex) {
		    ExceptionResponse exResponse =
				new ExceptionResponse(new Date(), HttpStatus.BAD_REQUEST.value(),ex.getBindingResult().getFieldError().getDefaultMessage());
			
							
			ResponseEntity<ExceptionResponse> response = 
				new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.BAD_REQUEST);
			return response;
		}
		
		// Exception Handler Method for request body is not proper 
		@ExceptionHandler(InterviewUserMappingAlreadyExistException.class)
		public ResponseEntity<ExceptionResponse> handler(InterviewUserMappingAlreadyExistException ex) {
		ExceptionResponse exResponse =
		new ExceptionResponse(new Date(), HttpStatus.BAD_REQUEST.value(),ex.getMessage());
		
									
		ResponseEntity<ExceptionResponse> response = 
						new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.BAD_REQUEST);
		return response;
		}
					
		
		// Exception Handler Method for all other Exception
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ExceptionResponse> handler(Exception ex) {
			ExceptionResponse exResponse =
					new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),ex.getMessage());
			
			ResponseEntity<ExceptionResponse> response = 
					new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.BAD_REQUEST);
			return response;
		}
			
		
	

}
