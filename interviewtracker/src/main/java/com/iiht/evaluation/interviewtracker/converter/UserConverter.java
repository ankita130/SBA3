package com.iiht.evaluation.interviewtracker.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iiht.evaluation.interviewtracker.dto.InterviewDto;
import com.iiht.evaluation.interviewtracker.dto.UserDto;
import com.iiht.evaluation.interviewtracker.entity.Interview;
import com.iiht.evaluation.interviewtracker.entity.User;

@Component
public class UserConverter {
	public UserDto entityToDto(User user)
	{
		UserDto dto=new UserDto();
		dto.setUserId(user.getId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setMobile(user.getMobile());	
		return dto;
		
	}
	
	public List<UserDto> entityToDto(List<User> users)
	{
		return users.stream().map(x->entityToDto(x)).collect(Collectors.toList());
		
	}
	
	public User dtoToEntity(UserDto dto)
	{
		User user=new User();
		user.setId(dto.getUserId());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setMobile(dto.getMobile());
			
		return user;
		
	}
	
	public List<User> dtoToEntity(List<UserDto> dtos)
	{
		return dtos.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
	

}
