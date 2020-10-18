package com.iiht.evaluation.interviewtracker.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class UserDto {

	private long userId;
	
	@NotBlank
	@Length(min=5 ,max=30 , message="The firstName is mandatory and should be between 5 to 30 chars")
	private String firstName; 
	
	@NotBlank
	@Length(min=3 ,max=25 , message="The lastName is mandatory and should be between 3 to 25 chars")
	private String lastName;
	
	@NotBlank(message="Email is mandatory")
	@Email(message="Email is not in valid email id")	
	private String email; 
	
	@NotBlank(message="Mobile number is mandatory")
	@Pattern(regexp="(^$|[0-9]{10})" , message="Not a valid Phone number.Phone number should contain 10 digits")
	private String mobile;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
