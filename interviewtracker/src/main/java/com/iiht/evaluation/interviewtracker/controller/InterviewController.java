package com.iiht.evaluation.interviewtracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.evaluation.interviewtracker.converter.InterviewConverter;
import com.iiht.evaluation.interviewtracker.dto.InterviewDto;
import com.iiht.evaluation.interviewtracker.entity.Interview;
import com.iiht.evaluation.interviewtracker.exception.InterviewNotFoundException;
import com.iiht.evaluation.interviewtracker.service.InterviewService;
import com.iiht.evaluation.interviewtracker.service.InterviewUserService;

@RestController
@RequestMapping("/api")
public class InterviewController {
	
	@Autowired
	InterviewService service;
	
	@Autowired
	InterviewUserService mappingService;
	
	@Autowired
	InterviewConverter converter;
	
	@GetMapping("/interviews")
	public ResponseEntity<List<InterviewDto>> getAllInterviews() {
		System.out.println("interviewName");
         List<Interview> interviews = this.service.getAll();
         List<InterviewDto> dtos=converter.entityToDto(interviews);
		ResponseEntity<List<InterviewDto>> response = 
				new ResponseEntity<List<InterviewDto>>(dtos, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/interviews/searchbyinterviewname/{interviewName}")
	public ResponseEntity<List<InterviewDto>> getAllInterviewsByInterviewName(@PathVariable("interviewName") String interviewName) {
		
		List<Interview> interviews = this.service.getByInterviewName(interviewName);
		if(interviews.size()==0)
		{
			 throw  new InterviewNotFoundException("Interview not Found with interview name-" + interviewName);
		}
        List<InterviewDto> dtos=converter.entityToDto(interviews);        
		ResponseEntity<List<InterviewDto>> response = 
				new ResponseEntity<List<InterviewDto>>(dtos, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/interviews/searchbyinterviewername/{interviewerName}")
	public ResponseEntity<List<InterviewDto>> getAllInterviewsByInterviewerName(@PathVariable("interviewerName") String interviewerName) {
		 List<Interview> interviews = this.service.getByInterviewerName(interviewerName);
		 if(interviews.size()==0)
		 {
			 throw  new InterviewNotFoundException("Interview not Found with interviewer name-" + interviewerName);
		 }
        List<InterviewDto> dtos=converter.entityToDto(interviews);
        
		ResponseEntity<List<InterviewDto>> response = 
				new ResponseEntity<List<InterviewDto>>(dtos, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/interviews/{id}")
	public InterviewDto deleteInterviewtById(@PathVariable("id") Long id) {
		Interview interview=this.service.searchById(id);
		if(interview==null)
		{
			throw  new InterviewNotFoundException("Interview not Found with Id-" + id);
		}
		InterviewDto deletedUser=converter.entityToDto(this.service.deleteById(id));
		this.mappingService.deleteByInterviewid(id);
		return deletedUser;
	}
	
	@PostMapping("/interviews")
	public ResponseEntity<InterviewDto> addInterview(@Valid @RequestBody InterviewDto interviewDto) {
		
		Interview interview=converter.dtoToEntity(interviewDto);
		Interview addedInterview=this.service.add(interview);
		InterviewDto addedInterviewDto=converter.entityToDto(addedInterview);
		ResponseEntity<InterviewDto> response = 
				new ResponseEntity<InterviewDto>(addedInterviewDto, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/interviews/{id}/{status}")
	public ResponseEntity<InterviewDto> updateStatus(@PathVariable("id") Long id,@PathVariable("status") String status) {
		Interview interview=this.service.searchById(id);
		if(interview==null)
		{
			throw  new InterviewNotFoundException("Interview not Found with Id-" + id);
		}
		interview.setInterviewStatus(status);		
		InterviewDto updatedInterviewDto=converter.entityToDto(this.service.updateStatus(interview));
		
		ResponseEntity<InterviewDto> response = 
				new ResponseEntity<InterviewDto>(updatedInterviewDto, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/count")
	public int getInterviewCount() {
         
		return this.service.getTotalNumberOfInterview();
	}
	

}
