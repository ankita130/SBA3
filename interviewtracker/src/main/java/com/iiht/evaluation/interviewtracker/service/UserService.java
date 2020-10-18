package com.iiht.evaluation.interviewtracker.service;
import java.util.List;

import com.iiht.evaluation.interviewtracker.entity.User;

public interface UserService {
	public List<User> getAll();
	public User add(User interview);
	public User deleteById(Long id);
	public User searchById(Long id);


}
