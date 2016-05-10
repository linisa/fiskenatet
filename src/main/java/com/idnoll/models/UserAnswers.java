package com.idnoll.models;

import java.util.ArrayList;
import java.util.List;

public class UserAnswers {

	
	List<String> answers = new ArrayList<>();
	
	public UserAnswers() {
	}

	
	
	public UserAnswers(String userAnswer) {
		answers.add(userAnswer);
	}



	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	  
}
