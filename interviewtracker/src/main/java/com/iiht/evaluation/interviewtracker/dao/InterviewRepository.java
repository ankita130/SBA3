package com.iiht.evaluation.interviewtracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.evaluation.interviewtracker.entity.Interview;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

//@NoRepositoryBean
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long>{
	@Query("select count(*) from Interview")
	int findNumberOfInterview();
	
	@Query("select i from Interview i where i.interviewName =?1")
	List<Interview> findByInterviewName(String interviewName);
	
	@Query(value="select i from Interview i where i.interviewerName =?1")
	List<Interview> findByInterviewerName(String interviewerName);

}
