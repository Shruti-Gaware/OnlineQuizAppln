package com.mydata.quiz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.quiz.dto.QuestionDto;
import com.mydata.quiz.exception.ResourceNotFoundException;
import com.mydata.quiz.service.QuestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/question")
public class QuestionController {

	private QuestionService qService;

	public QuestionController(QuestionService qService) {
		super();
		this.qService = qService;
	}
	
	@PostMapping
	public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto qDto)
	{
		QuestionDto savedQuestion = qService.createQuestion(qDto);
		return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<QuestionDto> getQuestionById(@PathVariable Long id) throws ResourceNotFoundException
	{
		QuestionDto savedQuestion = qService.getQuestionById(id);
		return ResponseEntity.ok(savedQuestion);
	}
	
	@GetMapping
	public ResponseEntity<List<QuestionDto>> getAllQuestions()
	{
		List<QuestionDto> allQuestions = qService.getAllQuestions();
		return ResponseEntity.ok(allQuestions);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<QuestionDto> updateQuestion(@PathVariable Long id , @RequestBody QuestionDto qDto) throws ResourceNotFoundException
	{
		QuestionDto updatedQuestion = qService.updateQuestion(id, qDto);
		return ResponseEntity.ok(updatedQuestion);	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Long id) throws ResourceNotFoundException
	{
		qService.deleteQuestion(id);
		return ResponseEntity.ok("Question Deleted Successfully!!!");
	}
}
