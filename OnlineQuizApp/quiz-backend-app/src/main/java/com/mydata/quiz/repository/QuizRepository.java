package com.mydata.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.quiz.dto.QuizDto;
import com.mydata.quiz.entity.Quiz;
import com.mydata.quiz.entity.User;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	public List<Quiz> findByUser(User user);

	
	
}
