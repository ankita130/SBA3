package com.iiht.evaluation.interviewtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.evaluation.interviewtracker.converter.InterviewUserConverter;
import com.iiht.evaluation.interviewtracker.dto.InterviewUserDto;
import com.iiht.evaluation.interviewtracker.entity.Interview;
import com.iiht.evaluation.interviewtracker.entity.InterviewUser;
import com.iiht.evaluation.interviewtracker.entity.User;
import com.iiht.evaluation.interviewtracker.exception.InterviewUserMappingAlreadyExistException;
import com.iiht.evaluation.interviewtracker.service.InterviewService;
import com.iiht.evaluation.interviewtracker.service.InterviewUserService;
import com.iiht.evaluation.interviewtracker.service.UserService;

@RestController
@RequestMapping("/api")
public class InterviewUserController {

	@Autowired
	InterviewUserService service;
	
	@Autowired
	InterviewService interviewService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	InterviewUserConverter converter;

	@GetMapping("/interviewuser/{interviewid}/{userid}")
	public ResponseEntity<InterviewUserDto> mapInterviewAndUser(@PathVariable("interviewid") Long interviewid,@PathVariable("userid") Long  userid) {
		System.out.println(interviewid);
		System.out.println(userid);
		InterviewUser interviewUser1=this.service.searchByInterviewidAndUserid(interviewid, userid);
		InterviewUser interviewUser2=new InterviewUser();
		if(interviewUser1!=null)
		{
			throw  new InterviewUserMappingAlreadyExistException("Interview id: " + interviewid+ " User id: "+ userid+ " Combination already present");
		}
		Interview interview=this.interviewService.searchById(interviewid);
		if(interview==null){
			throw  new InterviewUserMappingAlreadyExistException("Interview id: " + interviewid+ " is not a valid Interview Id");
		}		
		User user=this.userService.searchById(userid);
		if(user==null){
			throw  new InterviewUserMappingAlreadyExistException("User id: " + userid+ " is not a valid User Id");
		}
		interviewUser2.setUserId(userid);
		interviewUser2.setInterviewId(interviewid);
		
		InterviewUser interviewUser=this.service.add(interviewUser2);
		InterviewUserDto dto=converter.entityToDto(interviewUser);
		ResponseEntity<InterviewUserDto> response = 
				new ResponseEntity<InterviewUserDto>(dto, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/interviewusers")
	public ResponseEntity<List<InterviewUserDto>> getInterviewUserMapping() {
		System.out.println("Finally");
		 List<InterviewUser> mappings = this.service.getAll();
         List<InterviewUserDto> dtos=converter.entityToDto(mappings);
		ResponseEntity<List<InterviewUserDto>> response = 
				new ResponseEntity<List<InterviewUserDto>>(dtos, HttpStatus.OK);
		return response;
	}
	
	
}
