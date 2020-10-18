package com.iiht.evaluation.interviewtracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="user_interviews")
@IdClass(InterviewUserId.class)
public class InterviewUser {
    @Id
	@Column(name="interviews_id")
	private long interviewId;
    @Id
	@Column(name="users_id")
	private long userId;
	public long getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(long interviewId) {
		this.interviewId = interviewId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
