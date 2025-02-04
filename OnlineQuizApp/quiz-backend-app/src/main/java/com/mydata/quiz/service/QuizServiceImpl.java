package com.mydata.quiz.service;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.quiz.dto.QQuestionDto;
import com.mydata.quiz.dto.QuizDto;
import com.mydata.quiz.entity.Question;
import com.mydata.quiz.entity.Quiz;
import com.mydata.quiz.entity.QuizQuestion;
import com.mydata.quiz.entity.User;
import com.mydata.quiz.exception.ResourceNotFoundException;
import com.mydata.quiz.mapper.QQuestionMapper;
import com.mydata.quiz.mapper.QuizMapper;
import com.mydata.quiz.repository.QQuestionRepository;
import com.mydata.quiz.repository.QuestionRepository;
import com.mydata.quiz.repository.QuizRepository;
import com.mydata.quiz.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QQuestionRepository qqRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QQuestionService qqService;
	
	@Override
	@Transactional
	public QuizDto createRandomQuiz(String username, String topic, int noOfQuestions) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given username : "+ username));
		
		//fetch random questions
		List<Question> randomQuestions = questionRepository.findRandomQuestionByTopic(topic, noOfQuestions);
		if(randomQuestions.isEmpty()){
			throw new ResourceNotFoundException("Questions are not found of given topic : " + topic);
		}
		
		//create quiz
		Quiz quiz = new Quiz();
		quiz.setUser(user);
		quiz.setTotalQuestions(noOfQuestions); 
		
		//save quiz first to get an id
		Quiz savedQuiz = quizRepository.save(quiz);
		
		//add random questions to quiz
		List<QuizQuestion> quizQuestions = new ArrayList<>();
		for(Question question : randomQuestions){
			QuizQuestion quizQuestion = new QuizQuestion();
	        quizQuestion.setQuiz(savedQuiz);
	        quizQuestion.setQuestion(question);
	        quizQuestions.add(quizQuestion);
	    }
		
		// Save all quiz questions in bulk
	    qqRepository.saveAll(quizQuestions);

	    // Update quiz with quiz questions
	    savedQuiz.setQuizQuestion(quizQuestions);
	    savedQuiz = quizRepository.save(savedQuiz); // Save updated quiz
	    
		return QuizMapper.mapToQuizDto(savedQuiz);
	}
	

	@Override
	public QQuestionDto submitAnswer(long quizId, long qqId, String userAnswer) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz is not exists with given id: " + quizId));
		return qqService.updateUserAnswer(qqId, userAnswer);
	}


	@Override
	public QuizDto submitQuiz(long quizId) throws IllegalStateException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz is not exists with given id: " + quizId));
		
		//ensure all questions are answered
		if(!qqService.areAllQuestionsAnswered(quizId)) {
			throw new IllegalStateException("Not all Questions are Answered !!!");
		}
		
		//calculate the score
		List<QQuestionDto> quizQuestions = qqService.getQuestionsByQuiz(quizId);
		// Convert DTOs to entity objects
	    List<QuizQuestion> savedQuestions = quizQuestions.stream()
	            .map(QQuestionMapper::mapToQuizQuestion)
	            .collect(Collectors.toList());

	    // Calculate the score
	    int score = (int) savedQuestions.stream()
	            .filter(QuizQuestion::isCorrect)
	            .count();
	    
	    quiz.setScore(score);
	    
		quizRepository.save(quiz);
		return QuizMapper.mapToQuizDto(quiz);
	}


	@Override
	public List<QuizDto> getQuizGivenByUser(String username) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given Username: " + username));
		
		//return quizRepository.findByUser(user);
		List<Quiz> quiz = quizRepository.findByUser(user);
		return quiz.stream()
				.map(QuizMapper::mapToQuizDto)
				.collect(Collectors.toList());
	}


	@Override
	public List<QuizDto> getPastQuizAttempts(String username) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given Username: " + username));
		List<Quiz> pastAttempts = quizRepository.findByUser(user);
		if(pastAttempts.isEmpty())
		{
			throw new ResourceNotFoundException("No past quiz attempts found for user: \" + username");
		}
		return pastAttempts.stream()
				.map(QuizMapper::mapToQuizDto)
				.collect(Collectors.toList());
	}
	
	

}
