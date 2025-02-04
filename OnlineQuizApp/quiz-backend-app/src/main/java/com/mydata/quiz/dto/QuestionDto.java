package com.mydata.quiz.dto;

import java.util.List;

public class QuestionDto {

	private long id;
	private String topic;
	private String title;
	private List<String> options;
	private List<String> correctAnswer;
	
	
	public QuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public QuestionDto(long id, String topic, String title, List<String> options, List<String> correctAnswer) {
		super();
		this.id = id;
		this.topic = topic;
		this.title = title;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<String> getOptions() {
		return options;
	}


	public void setOptions(List<String> options) {
		this.options = options;
	}


	public List<String> getCorrectAnswer() {
		return correctAnswer;
	}


	public void setCorrectAnswer(List<String> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
}
