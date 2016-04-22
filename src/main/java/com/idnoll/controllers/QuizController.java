package com.idnoll.controllers;

import java.util.ArrayList;
import java.util.List;

import com.idnoll.models.QuestionModel;

public class QuizController {

	List<QuestionModel> questions = new ArrayList<>();
	
	public QuizController() {
		populateList();
		for (int i = 0; i < questions.size(); i++) {
			printQuestion(questions.get(i));
			getInput();
			checkIfRightAnswer(i);
		}
		
	}
	
	public void populateList(){
		//populera lista med questionModel objekt.
	}
	
	public void printQuestion(QuestionModel question){
		//printa ut frågan med svarsalternativ
	}
	
	public void getInput(){
		//ta input från användaren och sätt det till userAnswer i QuestionModel.
	}
	
	public void checkIfRightAnswer(Integer i){
	 
		if(questions.get(i).getCorrectAnswer().equals(questions.get(i).getUserAnswer())){
			System.out.println("Det var rätt svar!");
		}else{
			System.out.println("Det var fel");
		}
	}
}
