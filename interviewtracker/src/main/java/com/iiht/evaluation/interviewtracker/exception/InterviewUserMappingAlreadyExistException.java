package com.iiht.evaluation.interviewtracker.exception;

public class InterviewUserMappingAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InterviewUserMappingAlreadyExistException(String message) {
		super(message);
	}
}
