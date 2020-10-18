package com.iiht.evaluation.interviewtracker.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.evaluation.interviewtracker.dao.InterviewUserRepository;
import com.iiht.evaluation.interviewtracker.entity.InterviewUser;
import com.iiht.evaluation.interviewtracker.entity.User;
import com.iiht.evaluation.interviewtracker.service.InterviewUserService;
@Service
public class InterviewUserServiceImpl implements InterviewUserService{
	
	@Autowired
	InterviewUserRepository repository;

	@Override
	public List<InterviewUser> getAll() {
		return this.repository.findAll();
	}

	@Override
	public InterviewUser add(InterviewUser interviewUser) {

		return this.repository.save(interviewUser);
	}

	@Override
	public InterviewUser searchByInterviewidAndUserid(Long interviewId, Long userId) {
		return this.repository.findByInterviewIdUserId(interviewId,userId);
	}

	
	@Override
	public void deleteByUserid(Long userId) {
		InterviewUser mapping=this.repository.searchByUserId(userId);
		if(mapping!=null)
		{
			this.repository.deleteByUserId(userId);
		}
		
	}

	@Override
	public void deleteByInterviewid(Long interviewId) {
		InterviewUser mapping=this.repository.searchByInterviewId(interviewId);
		if(mapping!=null)
		{
			this.repository.deleteByInterviewId(interviewId);
		}
		
	}
}
