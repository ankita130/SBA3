package com.iiht.evaluation.interviewtracker.service.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.evaluation.interviewtracker.dao.InterviewRepository;
import com.iiht.evaluation.interviewtracker.entity.Interview;
import com.iiht.evaluation.interviewtracker.entity.User;
import com.iiht.evaluation.interviewtracker.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService{

	@Autowired
	InterviewRepository repository;
	
	@Override
	public List<Interview> getAll() {
		
		return this.repository.findAll();
	}

	@Override
	public List<Interview> getByInterviewName(String interviewName) {
	
		return repository.findByInterviewName(interviewName);
	}

	@Override
	public Interview add(Interview interview) {
		
		return this.repository.save(interview);
	}

	@Override
	public Interview updateStatus(Interview interview) {
		// TODO Auto-generated method stub
		return this.repository.save(interview);
	}

	@Override
	public Interview deleteById(Long id) {
		Interview interview=this.repository.getOne(id);
		if(interview!=null)
			this.repository.delete(interview);
		return interview;
	}

	@Override
	public List<Interview> getByInterviewerName(String interviewerName) {
		
		return this.repository.findByInterviewerName(interviewerName);
	}

	@Override
	public int getTotalNumberOfInterview() {
		
		return this.repository.findNumberOfInterview();
	}
	
	@Override
	public Interview searchById(Long id) {
		Interview interview=this.repository.findById(id).orElse(null);
		if(interview!=null)
		{
			System.out.println("interview found");
		}
		else
			System.out.println("interview not found");
		return interview;
	}
	
	

}
