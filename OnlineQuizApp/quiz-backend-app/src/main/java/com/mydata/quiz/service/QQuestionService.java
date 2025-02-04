package com.mydata.quiz.service;

import java.util.List;

import com.mydata.quiz.dto.QQuestionDto;
import com.mydata.quiz.dto.QuizDto;
import com.mydata.quiz.exception.ResourceNotFoundException;

public interface QQuestionService {

	public QQuestionDto addQuestionsToQuiz(QuizDto savedQuiz, long questionId) throws ResourceNotFoundException;
	public QQuestionDto updateUserAnswer(long qqId, String userAnswer) throws ResourceNotFoundException;
	public List<QQuestionDto> getQuestionsByQuiz(long quizId);
	public boolean areAllQuestionsAnswered(long quizId);
}
