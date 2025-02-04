package com.mydata.quiz.mapper;

import com.mydata.quiz.dto.QuestionDto;
import com.mydata.quiz.entity.Question;

public class QuestionMapper {

	public static Question mapToQuestion(QuestionDto qDto)
	{
		return new Question(qDto.getId(), qDto.getTopic(), qDto.getTitle(), qDto.getOptions(), qDto.getCorrectAnswer());
	}
	
	public static QuestionDto mapToQuestionDto(Question q)
	{
		return new QuestionDto(q.getId(), q.getTopic(), q.getTitle(), q.getOptions(), q.getCorrectAnswer());
	}
	
}
