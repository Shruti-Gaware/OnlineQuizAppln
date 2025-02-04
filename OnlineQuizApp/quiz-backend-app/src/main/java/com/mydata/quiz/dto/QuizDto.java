package com.mydata.quiz.dto;

import java.util.List;

import com.mydata.quiz.entity.QuizQuestion;
import com.mydata.quiz.entity.User;

public class QuizDto {

	private long id;
	private User user;
	private List<QuizQuestion> quizQuestion;
	private int score;
	private int totalQuestions;

	public QuizDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QuizDto(long id, User user, List<QuizQuestion> quizQuestion, int score, int totalQuestions) {
		super();
		this.id = id;
		this.user = user;
		this.quizQuestion = quizQuestion;
		this.score = score;
		this.totalQuestions = totalQuestions;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<QuizQuestion> getQuizQuestion() {
		return quizQuestion;
	}
	public void setQuizQuestion(List<QuizQuestion> quizQuestion) {
		this.quizQuestion = quizQuestion;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	
	
}
