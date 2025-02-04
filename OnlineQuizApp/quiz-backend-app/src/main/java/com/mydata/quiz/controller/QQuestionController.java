package com.mydata.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.quiz.dto.QQuestionDto;
import com.mydata.quiz.dto.QuizDto;
import com.mydata.quiz.exception.ResourceNotFoundException;
import com.mydata.quiz.service.QQuestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/QQuestion")
public class QQuestionController {

	@Autowired
	private QQuestionService qqService;
	
	@PostMapping("/addQuestion")
	public ResponseEntity<QQuestionDto> addQuestionsToQuiz(@RequestBody QuizDto quizDto, @PathVariable long questionId) throws ResourceNotFoundException
	{
		QQuestionDto savedQuestions = qqService.addQuestionsToQuiz(quizDto, questionId);
		return new ResponseEntity<>(savedQuestions, HttpStatus.CREATED);	
	}
	
	@PutMapping("/submitAnswer/{id}/userAnswer")
	public ResponseEntity<QQuestionDto> submitUserAnswer(@PathVariable long qqId, @RequestParam String userAnswer) throws ResourceNotFoundException
	{
		QQuestionDto savedQuestions = qqService.updateUserAnswer(qqId, userAnswer);
		return ResponseEntity.ok(savedQuestions);
	}
	
	@GetMapping("/getQuestions/{id}")
	public ResponseEntity<List<QQuestionDto>> getQuestionsByQuiz(@PathVariable long quizId)
	{
		List<QQuestionDto>allQuestions = qqService.getQuestionsByQuiz(quizId);
		return ResponseEntity.ok(allQuestions);
	}
	
	@GetMapping("/AnsweredQuestions/{id}")
	public ResponseEntity<Boolean> areAllQuestionsAnswered(@PathVariable long quizId)
	{
		boolean allAnswered = qqService.areAllQuestionsAnswered(quizId);
		return ResponseEntity.ok(allAnswered);
	}
	
}
