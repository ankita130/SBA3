package com.iiht.evaluation.interviewtracker.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.evaluation.interviewtracker.converter.UserConverter;
import com.iiht.evaluation.interviewtracker.dto.UserDto;
import com.iiht.evaluation.interviewtracker.entity.User;
import com.iiht.evaluation.interviewtracker.exception.UserNotFoundException;
import com.iiht.evaluation.interviewtracker.service.InterviewUserService;
import com.iiht.evaluation.interviewtracker.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	InterviewUserService mappingService;
	
	@Autowired
	UserConverter converter;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		
         List<User> users = this.service.getAll();
         List<UserDto> dtos=converter.entityToDto(users);
		ResponseEntity<List<UserDto>> response = 
				new ResponseEntity<List<UserDto>>(dtos, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/users/{id}")
	public UserDto deleteUserById(@PathVariable("id") Long id) {
		User user=this.service.searchById(id);
		if(user==null)
		{
			throw  new UserNotFoundException("User not Found with Id-" + id);
		}
		UserDto deletedUser=converter.entityToDto(this.service.deleteById(id));
		this.mappingService.deleteByUserid(id);
	    return deletedUser;
		
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
		
		User user=converter.dtoToEntity(userDto);
		User addedUser=this.service.add(user);
		UserDto addedUserDto=converter.entityToDto(addedUser);
		ResponseEntity<UserDto> response = 
				new ResponseEntity<UserDto>(addedUserDto, HttpStatus.OK);
		return response;
	}


}
