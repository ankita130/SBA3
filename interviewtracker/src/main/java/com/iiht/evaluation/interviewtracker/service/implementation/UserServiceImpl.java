package com.iiht.evaluation.interviewtracker.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.evaluation.interviewtracker.dao.UserRepository;
import com.iiht.evaluation.interviewtracker.entity.Interview;
import com.iiht.evaluation.interviewtracker.entity.User;
import com.iiht.evaluation.interviewtracker.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAll() {
		return this.repository.findAll();
	}

	@Override
	public User add(User user) {
		
		return this.repository.save(user);
	}

	@Override
	public User deleteById(Long id) {
		User user=this.searchById(id);
		if(user!=null)
		{
			this.repository.deleteById(id);
		}
		
		return user;
	}

	@Override
	public User searchById(Long id) {
		User user=this.repository.findById(id).orElse(null);
		if(user!=null)
		{
			System.out.println("user found");
		}
		else
			System.out.println("user not found");
		return user;
	}

}
