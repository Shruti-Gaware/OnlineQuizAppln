package com.mydata.quiz.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name= "question")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name= "title")
	private String title;
	
	
	@ElementCollection
	@CollectionTable(name =  "question_options",
					joinColumns = @JoinColumn(name = "question_id", nullable = false)) 
	@Column(name = "options", nullable = false)
	private List<String> options;
	
	
	@Column(name = "correctAnswer", nullable = false)
	@ElementCollection
	@CollectionTable(name = "question_correctAnswer",
					joinColumns = @JoinColumn(name = "question_id", nullable = false))
	private List<String> correctAnswer;
	
	
	//@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	//@OneToOne(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(long id, String topic, String title,List<String> options, List<String> correctAnswer) {
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
