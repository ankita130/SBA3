package com.iiht.evaluation.interviewtracker.exception.model;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

	private  Date timestamp;
	private long status;
	private String message;	
	
	public ExceptionResponse() {
		
	}
	
    public ExceptionResponse(Date timestamp,long status, String message) {
		this.message=message;
		this.status=status ;
		this.timestamp=timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timestamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timestamp = timeStamp;
	}
	
	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}
}