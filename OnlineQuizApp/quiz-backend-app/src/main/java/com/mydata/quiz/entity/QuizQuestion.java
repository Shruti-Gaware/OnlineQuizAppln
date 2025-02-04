package com.mydata.quiz.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizQuestion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class QuizQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "quiz_id", nullable = false)
	@JsonBackReference
	private Quiz quiz;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "question_id", nullable = false)
	private Question question;
	
	@Column(name = "userAnswer")
	private String userAnswer;
	
	@Column(name = "isCorrect")
	private boolean isCorrect;

	public QuizQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizQuestion(long id, Quiz quiz, Question question, String userAnswer, boolean isCorrect) {
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
