package com.iiht.evaluation.interviewtracker.service;

import java.util.List;

import com.iiht.evaluation.interviewtracker.entity.InterviewUser;
import com.iiht.evaluation.interviewtracker.entity.User;

public interface InterviewUserService {

	public List<InterviewUser> getAll();
	public InterviewUser add(InterviewUser interviewUser);
	public InterviewUser searchByInterviewidAndUserid(Long interviewId, Long userId);
	void deleteByUserid(Long userId);
	void deleteByInterviewid(Long interviewId);
}