package com.iiht.evaluation.interviewtracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.evaluation.interviewtracker.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	/*@Query("select * from User u where u.userId=:id")
	User findByUserId(@Param("id") Long id);*/

}
