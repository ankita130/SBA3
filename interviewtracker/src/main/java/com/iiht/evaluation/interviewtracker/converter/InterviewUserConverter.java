package com.iiht.evaluation.interviewtracker.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iiht.evaluation.interviewtracker.dto.InterviewDto;
import com.iiht.evaluation.interviewtracker.dto.InterviewUserDto;
import com.iiht.evaluation.interviewtracker.entity.Interview;
import com.iiht.evaluation.interviewtracker.entity.InterviewUser;

@Component
public class InterviewUserConverter {

	public InterviewUserDto entityToDto(InterviewUser interviewUser)
	{
		InterviewUserDto dto=new InterviewUserDto();
		dto.setUserId(interviewUser.getUserId());
		dto.setInterviewId(interviewUser.getInterviewId());
			
		return dto;
		
	}
	
	public InterviewUserDto entityToDto(InterviewUser interviewUser,String interviewName,String userName)
	{
		InterviewUserDto dto=new InterviewUserDto();
		dto.setUserId(interviewUser.getUserId());
		dto.setInterviewId(interviewUser.getInterviewId());
			
		return dto;
		
	}
	
	public List<InterviewUserDto> entityToDto(List<InterviewUser> interviewUsers)
	{
		return interviewUsers.stream().map(x->entityToDto(x)).collect(Collectors.toList());
		
	}
	
	public InterviewUser dtoToEntity(InterviewUserDto dto)
	{
		InterviewUser interviewUser=new InterviewUser();
		interviewUser.setUserId(dto.getUserId());
		interviewUser.setInterviewId(dto.getInterviewId());
		return interviewUser;
		
	}
	
	public List<InterviewUser> dtoToEntity(List<InterviewUserDto> dtos)
	{
		return dtos.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
	
	

}
