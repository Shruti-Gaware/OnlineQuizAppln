package com.mydata.quiz.mapper;

import com.mydata.quiz.dto.QuizDto;
import com.mydata.quiz.entity.Quiz;

public class QuizMapper 
	{

	public static Quiz mapToQuiz(QuizDto quizDto) {
		return new Quiz(quizDto.getId(), quizDto.getUser(), quizDto.getQuizQuestion(), quizDto.getScore(), quizDto.getTotalQuestions());
	}
	
	public static QuizDto mapToQuizDto(Quiz quiz)
	{
		return new QuizDto(quiz.getId(), quiz.getUser(), quiz.getQuizQuestion(), quiz.getScore(), quiz.getTotalQuestions());
	}
	
}
