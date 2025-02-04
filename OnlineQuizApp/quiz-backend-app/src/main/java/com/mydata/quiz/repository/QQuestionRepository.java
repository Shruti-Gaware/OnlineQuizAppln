package com.mydata.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mydata.quiz.dto.QQuestionDto;
import com.mydata.quiz.entity.QuizQuestion;

public interface QQuestionRepository extends JpaRepository<QuizQuestion, Long>{

	@Query(value = "SELECT * FROM quizQuestion WHERE quizId = :quizId", nativeQuery = true)
	public List<QQuestionDto> findByQuizId(@Param("quizId") long quizId);

}
