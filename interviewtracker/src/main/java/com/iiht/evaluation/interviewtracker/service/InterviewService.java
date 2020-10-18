package com.iiht.evaluation.interviewtracker.service;

import java.util.List;

import com.iiht.evaluation.interviewtracker.entity.Interview;
import com.iiht.evaluation.interviewtracker.entity.User;

public interface InterviewService {
	public List<Interview> getAll();
	public List<Interview> getByInterviewName(String interviewName);
	public Interview add(Interview interview);
	public Interview updateStatus(Interview interview);
	public Interview deleteById(Long id);
	public List<Interview> getByInterviewerName(String interviewerName);
	public int getTotalNumberOfInterview();
	public Interview searchById(Long id);

}
