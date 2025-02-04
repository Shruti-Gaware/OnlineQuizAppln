package com.mydata.quiz.dto;

import java.util.List;

import com.mydata.quiz.entity.Quiz;

public class UserDto {
	
	private long id;
	private String username;
	private String password;
	private List<Quiz> quizzes;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserDto(long id, String username, String password, List<Quiz> quizzes) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.quizzes = quizzes;
	}
	
	//setter getter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	
		

}
