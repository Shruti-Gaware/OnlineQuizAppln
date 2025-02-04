package com.mydata.quiz.dto;

import com.mydata.quiz.entity.Question;

import com.mydata.quiz.entity.Quiz;

public class QQuestionDto {

	private long id;
	private Quiz quiz;
	private Question question;
	private String userAnswer;
	private boolean isCorrect;
	
	public QQuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QQuestionDto(long id, Quiz quiz, Question question, String userAnswer, boolean isCorrect) {
		super();
		this.id = id;
		this.quiz = quiz;
		this.question = question;
		this.userAnswer = userAnswer;
		this.isCorrect = isCorrect;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	
}
