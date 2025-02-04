package com.mydata.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mydata.quiz.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	@Query(value = "SELECT * FROM question WHERE topic = ?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	public List<Question> findRandomQuestionByTopic(String topic, int limit);
	
	
}
