package com.iiht.evaluation.interviewtracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iiht.evaluation.interviewtracker.entity.Interview;
import com.iiht.evaluation.interviewtracker.entity.InterviewUser;
@Repository
public interface InterviewUserRepository extends JpaRepository<InterviewUser,Long>{

	@Query("select i from InterviewUser i where i.interviewId =?1 And i.userId=?2")
	InterviewUser findByInterviewIdUserId(Long interviewId,Long userId);
	
	@Query("delete from InterviewUser i where i.userId=?1")
	InterviewUser deleteByUserId(Long userId);
	
	@Query("delete from InterviewUser i where i.interviewId=?1")
	InterviewUser deleteByInterviewId(Long interviewId);
	
	@Query("select i from InterviewUser i where i.userId=?1")
	InterviewUser searchByUserId(Long userId);
	
	@Query("select i from InterviewUser i where i.interviewId=?1")
	InterviewUser searchByInterviewId(Long interviewId);
}
