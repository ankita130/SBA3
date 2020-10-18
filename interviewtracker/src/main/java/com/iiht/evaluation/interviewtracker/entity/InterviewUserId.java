package com.iiht.evaluation.interviewtracker.entity;

import java.io.Serializable;

public class InterviewUserId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long interviewId;
	
	private long userId;
	
	public InterviewUserId(long interviewId, long userId) {
        this.setInterviewId(interviewId);
        this.setUserId(userId);
    }
	
	public InterviewUserId() {
    }

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(long interviewId) {
		this.interviewId = interviewId;
	}

}
