package com.mydata.quiz.service;

import java.util.List;

import com.mydata.quiz.dto.QuestionDto;
import com.mydata.quiz.exception.ResourceNotFoundException;

public interface QuestionService {

	public QuestionDto createQuestion(QuestionDto qDto);
	public QuestionDto getQuestionById(Long id)throws ResourceNotFoundException;
	public List<QuestionDto> getAllQuestions();
	public QuestionDto updateQuestion(Long id, QuestionDto qDto)throws ResourceNotFoundException;
	public void deleteQuestion(Long id)throws ResourceNotFoundException;

}
