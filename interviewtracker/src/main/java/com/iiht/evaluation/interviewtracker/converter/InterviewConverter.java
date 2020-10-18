package com.iiht.evaluation.interviewtracker.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iiht.evaluation.interviewtracker.dto.InterviewDto;
import com.iiht.evaluation.interviewtracker.entity.Interview;

@Component
public class InterviewConverter {
	
	public InterviewDto entityToDto(Interview interview)
	{
		InterviewDto dto=new InterviewDto();
		dto.setInterviewId(interview.getInterviewId());
		dto.setInterviewerName(interview.getInterviewerName());
		dto.setInterviewName(interview.getInterviewName());
		dto.setInterviewStatus(interview.getInterviewStatus());
		dto.setDate(interview.getDate());
		dto.setRemarks(interview.getRemarks());
		dto.setUsersSkill(interview.getUsersSkill());
			
		return dto;
		
	}
	
	public List<InterviewDto> entityToDto(List<Interview> interviews)
	{
		return interviews.stream().map(x->entityToDto(x)).collect(Collectors.toList());
		
	}
	
	public Interview dtoToEntity(InterviewDto dto)
	{
		Interview interview=new Interview();
		interview.setInterviewId(dto.getInterviewId());
		interview.setInterviewerName(dto.getInterviewerName());
		interview.setInterviewName(dto.getInterviewName());
		interview.setInterviewStatus(dto.getInterviewStatus());
		interview.setDate(dto.getDate());
		interview.setRemarks(dto.getRemarks());
		interview.setUsersSkill(dto.getUsersSkill());
			
		return interview;
		
	}
	
	public List<Interview> dtoToEntity(List<InterviewDto> dtos)
	{
		return dtos.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
	
	


}
