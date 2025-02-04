package com.mydata.quiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mydata.quiz.dto.QuestionDto;
import com.mydata.quiz.entity.Question;
import com.mydata.quiz.exception.ResourceNotFoundException;
import com.mydata.quiz.mapper.QuestionMapper;
import com.mydata.quiz.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	private QuestionRepository qRepository;
	
	public QuestionServiceImpl(QuestionRepository qRepository) {
		super();
		this.qRepository = qRepository;
	}


	@Override
	public QuestionDto createQuestion(QuestionDto qDto) {
		// TODO Auto-generated method stub
		Question question = QuestionMapper.mapToQuestion(qDto);
		Question savedQuestion = qRepository.save(question);
		return(QuestionMapper.mapToQuestionDto(savedQuestion));
		
		//QuestionDto newQuestion = QuestionMapper.mapToQuestionDto(savedQuestion);
		//return newQuestion;
	}


	@Override
	public QuestionDto getQuestionById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Question question = qRepository.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException("Question not exists with id : "+ id));
		return QuestionMapper.mapToQuestionDto(question);
	}


	@Override
	public List<QuestionDto> getAllQuestions() {
		// TODO Auto-generated method stub
		List<Question> allQuestion = qRepository.findAll();
		List<QuestionDto> savedQuestions = allQuestion.stream()
				.map(question -> QuestionMapper.mapToQuestionDto(question))
				.collect(Collectors.toList());
		return savedQuestions;
	}


	@Override
	public QuestionDto updateQuestion(Long id, QuestionDto qDto) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Question q = qRepository.findById(id)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Question not exists with id : \"+ id"));
		
		q.setTopic(qDto.getTopic());
		q.setTitle(qDto.getTitle());
		q.setOptions(qDto.getOptions());
		q.setCorrectAnswer(qDto.getCorrectAnswer());
		
		Question savedQuestion = qRepository.save(q);
		return QuestionMapper.mapToQuestionDto(savedQuestion);
	}


	@Override
	public void deleteQuestion(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Question question = qRepository.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException("Question not exists with id : \\\"+ id"));
		qRepository.deleteById(id);
	}
	

	
}
