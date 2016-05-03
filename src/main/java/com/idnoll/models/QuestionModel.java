package com.idnoll.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuestionModel {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long subCategory;
	private String category;
	
	private String question;
	private String correctAnswer;
	private String firstWrongAnswer;
	private String secondWrongAnswer;
	private String userAnswer;
	
	private String[] randomPosition;
	
	
	public QuestionModel() {
		
	}
	
	public QuestionModel( String question, String correctAnswer,
			String firstWrongAnswer, String secondWrongAnswer, String category, Long subCategory) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.firstWrongAnswer = firstWrongAnswer;
		this.secondWrongAnswer = secondWrongAnswer;
		this.category = category;
		this.subCategory = subCategory;
		setRandomPosition();
	}

	public String[] getShuffledAnswers(){
		List<String> randomAnswers = new ArrayList<>();
	
		randomAnswers.add(getCorrectAnswer());
		randomAnswers.add(getFirstWrongAnswer());
		randomAnswers.add(getSecondWrongAnswer());
	
		Collections.shuffle(randomAnswers);
		String[] randomAnswersArray = {randomAnswers.get(0),randomAnswers.get(1),randomAnswers.get(2)};
		return randomAnswersArray;
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

	public String getFirstWrongAnswer() {
		return firstWrongAnswer;
	}

	public void setFirstWrongAnswer(String firstWrongAnswer) {
		this.firstWrongAnswer = firstWrongAnswer;
	}

	public String getSecondWrongAnswer() {
		return secondWrongAnswer;
	}

	public void setSecondWrongAnswer(String secondWrongAnswer) {
		this.secondWrongAnswer = secondWrongAnswer;
	}

	public Long getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Long subCategory) {
		this.subCategory = subCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String[] getRandomPosition() {
		return randomPosition;
	}
	
	public void setRandomPosition() {
		randomPosition = getShuffledAnswers();
	}



	@Override
	public String toString() {
		return "QuestionModel [id=" + id + ", subCategory=" + subCategory + ", category=" + category + ", question="
				+ question + ", correctAnswer=" + correctAnswer + ", firstWrongAnswer=" + firstWrongAnswer
				+ ", secondWrongAnswer=" + secondWrongAnswer + ", userAnswer=" + userAnswer + "]";
	}


	
	
}
