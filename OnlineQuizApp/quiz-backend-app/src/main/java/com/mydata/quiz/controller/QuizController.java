package com.mydata.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.quiz.dto.QQuestionDto;
import com.mydata.quiz.dto.QuizDto;
import com.mydata.quiz.exception.ResourceNotFoundException;
import com.mydata.quiz.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/createRandom")
	public ResponseEntity<QuizDto> createRandomQuiz(@RequestParam String username, 
			@RequestParam String topic, @RequestParam int noOfQuestions) throws ResourceNotFoundException
	{
		QuizDto savedQuiz = quizService.createRandomQuiz(username, topic, noOfQuestions);
		return new ResponseEntity<>(savedQuiz, HttpStatus.CREATED);
	}
	
	@PostMapping("/submitAnswer/{quizId}/{qqId}")
	public ResponseEntity<QQuestionDto> submitAnswer(@PathVariable long quizId, @PathVariable long qqId, 
			@RequestParam String userAnswer) throws ResourceNotFoundException
	{
		QQuestionDto savedQuestion = quizService.submitAnswer(quizId, qqId, userAnswer);
		return ResponseEntity.ok(savedQuestion);
	}
	
	@PostMapping("submitQuiz/{quizId}")
	public ResponseEntity<QuizDto> submitQuiz(@PathVariable long quizId) throws RuntimeException, ResourceNotFoundException
	{
		QuizDto savedQuiz = quizService.submitQuiz(quizId);
		return ResponseEntity.ok(savedQuiz);
	}
	
	@GetMapping("/userQuizzes/{username}")
	public ResponseEntity<List<QuizDto>> getQuizGivenByUser(@PathVariable String username) throws ResourceNotFoundException
	{
		List<QuizDto> userQuizzes = quizService.getQuizGivenByUser(username);
		return ResponseEntity.ok(userQuizzes);
	}
	
	@GetMapping("/pastAttempts/{username}")
	public ResponseEntity<List<QuizDto>> getPastQuizAttempts(@PathVariable String username) throws ResourceNotFoundException
	{
		List<QuizDto> pastAttempts = quizService.getPastQuizAttempts(username);
		return ResponseEntity.ok(pastAttempts);
	}
}
