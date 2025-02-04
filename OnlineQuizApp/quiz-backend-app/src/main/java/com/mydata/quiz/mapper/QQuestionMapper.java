package com.mydata.quiz.mapper;

import com.mydata.quiz.dto.QQuestionDto;
import com.mydata.quiz.entity.QuizQuestion;

public class QQuestionMapper {

	public static QuizQuestion mapToQuizQuestion(QQuestionDto qqDto)
	{
		return new QuizQuestion(qqDto.getId(), qqDto.getQuiz(), qqDto.getQuestion(), qqDto.getUserAnswer(), qqDto.isCorrect());
	}
	
	public static QQuestionDto mapToQQuestionDto(QuizQuestion qq)
	{
		return new QQuestionDto(qq.getId(), qq.getQuiz(), qq.getQuestion(), qq.getUserAnswer(), qq.isCorrect());
	}
}
