package com.iiht.evaluation.interviewtracker.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data

public class InterviewDto {

	private long interviewId;
	
	@NotNull
	@Size(min=5 ,max=30 , message="The interviewerName is mandatory and should be between 5 to 30 chars long")
	private String interviewerName;	
	
	@NotNull
	@Size(min=3 ,max=30 , message="The interviewName is mandatory and should be between 5 to 30 chars long")
	private String interviewName;
	
	@NotNull
	@Size(min=5 ,max=30 , message="Skill is mandatory and each skill should be between 5 to 30 chars long")
	private String usersSkill;
	
	private String time;
	
	
	private Date date;
	
	@NotBlank
	@Size(min=5 ,max=100 , message="status is mandatory and should be between 5 to 100 chars long")
	private String interviewStatus;
	
	@NotBlank
	@Size(min=5 ,max=100 , message="remarks is mandatory and should be between 5 to 100 chars long")
	private String remarks ;
	
	public long getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(long interviewId) {
		this.interviewId = interviewId;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getInterviewName() {
		return interviewName;
	}
	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}
	public String getUsersSkill() {
		return usersSkill;
	}
	public void setUsersSkill(String usersSkill) {
		this.usersSkill = usersSkill;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
