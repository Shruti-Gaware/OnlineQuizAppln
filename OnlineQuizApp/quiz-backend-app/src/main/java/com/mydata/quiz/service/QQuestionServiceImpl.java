package com.mydata.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.quiz.dto.QQuestionDto;
import com.mydata.quiz.dto.QuizDto;
import com.mydata.quiz.entity.Question;
import com.mydata.quiz.entity.QuizQuestion;
import com.mydata.quiz.exception.ResourceNotFoundException;
import com.mydata.quiz.mapper.QQuestionMapper;
import com.mydata.quiz.mapper.QuizMapper;
import com.mydata.quiz.repository.QQuestionRepository;
import com.mydata.quiz.repository.QuestionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QQuestionServiceImpl implements QQuestionService{

	@Autowired
	QQuestionRepository qqRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Override
	public QQuestionDto addQuestionsToQuiz(QuizDto quizDto, long questionId) throws ResourceNotFoundException  {
		// TODO Auto-generated method stub
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not exists with given id : " + questionId));
		
		QuizQuestion quizQuestion = new QuizQuestion();
		quizQuestion.setQuiz(QuizMapper.mapToQuiz(quizDto));
		quizQuestion.setQuestion(question);
	
		QuizQuestion savedQuestion = qqRepository.save(quizQuestion);
		return QQuestionMapper.mapToQQuestionDto(savedQuestion);
	}

	@Override
	public QQuestionDto updateUserAnswer(long qqId, String userAnswer) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		QuizQuestion quizQuestion = qqRepository.findById(qqId)
				.orElseThrow(()-> new ResourceNotFoundException("Quiz Question not exists with given id : " + qqId));
		
		quizQuestion.setUserAnswer(userAnswer);
		
		//validate the user answer
		boolean isCorrect = quizQuestion.getQuestion().getCorrectAnswer().contains(userAnswer);
		quizQuestion.setCorrect(isCorrect);
		
		QuizQuestion savedQuestion = qqRepository.save(quizQuestion);
		return QQuestionMapper.mapToQQuestionDto(savedQuestion);
	}

	@Override
	public List<QQuestionDto> getQuestionsByQuiz(long quizId) {
		// TODO Auto-generated method stub
		List<QQuestionDto> allQuestions = qqRepository.findByQuizId(quizId);
		return allQuestions;
	}

	@Override
	public boolean areAllQuestionsAnswered(long quizId) {
		// TODO Auto-generated method stub
		List<QQuestionDto> allQuestions = qqRepository.findByQuizId(quizId);
		return allQuestions.stream().allMatch(q -> q.getUserAnswer() != null);
		
	}
	
	

	
}
