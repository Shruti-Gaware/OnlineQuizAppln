package com.mydata.quiz.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "username")
	private String username;
	
	@Column(name= "password")
	private String password;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Quiz> quizzes;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(long id, String username, String password, List<Quiz> quizzes) {
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
