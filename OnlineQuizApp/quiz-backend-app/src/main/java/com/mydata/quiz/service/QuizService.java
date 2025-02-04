package com.mydata.quiz.service;

import java.util.List;

import com.mydata.quiz.dto.QQuestionDto;
import com.mydata.quiz.dto.QuizDto;
import com.mydata.quiz.exception.ResourceNotFoundException;

public interface QuizService {
	
	public QuizDto createRandomQuiz(String username, String topic, int noOfQuestions) throws ResourceNotFoundException;
	public QQuestionDto submitAnswer(long quizId, long qqId, String userAnswer) throws ResourceNotFoundException;
	public QuizDto submitQuiz(long quizId)throws RuntimeException , ResourceNotFoundException;
	public List<QuizDto> getQuizGivenByUser(String username) throws ResourceNotFoundException;
	public List<QuizDto> getPastQuizAttempts(String username) throws ResourceNotFoundException;
}
