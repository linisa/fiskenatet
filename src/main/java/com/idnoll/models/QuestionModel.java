package com.idnoll.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuestionModel {

	@Id
	@GeneratedValue
	private Long id;
	
	private String question;
	private String correctAnswer;
	private String wrongAnswer;
	private String wrongAnswer2;
	private String topic;
	private String userAnswer;
	
	
	public QuestionModel() {
		
	}
	
	public QuestionModel(String question, String correctAnswer, String wrongAnswer, String wrongAnswer2, String topic) {
		super();
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.wrongAnswer = wrongAnswer;
		this.wrongAnswer2 = wrongAnswer2;
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}
	
	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getWrongAnswer() {
		return wrongAnswer;
	}

	public void setWrongAnswer(String wrongAnswer) {
		this.wrongAnswer = wrongAnswer;
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "QuestionModel [id=" + id + ", question=" + question + ", correctAnswer=" + correctAnswer
				+ ", wrongAnswer=" + wrongAnswer + ", wrongAnswer2=" + wrongAnswer2 + ", topic=" + topic + "]";
	}	
}
