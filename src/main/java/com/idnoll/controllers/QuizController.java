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
		QuestionModel questionOne = new QuestionModel();
		questionOne.setQuestion("En mycket känd NBA-spelare avslutade sin karriär nyligen. Han heter Bryant i efternamn, men vad heter han i förnamn?");
		questionOne.setCorrectAnswer("Kobe");
		questionOne.setWrongAnswer("Code");
		questionOne.setWrongAnswer2("Frode");
		questionOne.setTopic("Sport");
		questions.add(questionOne);
		
		QuestionModel questionTwo = new QuestionModel();
		questionTwo.setQuestion("I september startar en hockeyturnering med världens bästa herrspelare. Vad heter turneringen?");
		questionTwo.setCorrectAnswer("World Cup of Hockey");
		questionTwo.setWrongAnswer("Stanley Cup");
		questionTwo.setWrongAnswer2("Connie Smythe Memorial Cup");
		questionTwo.setTopic("Sport");
		questions.add(questionTwo);
		
		QuestionModel questionThree = new QuestionModel();
		questionThree.setQuestion("Var spelas fotbolls-EM 2016?");
		questionThree.setCorrectAnswer("Frankrike");
		questionThree.setWrongAnswer("Spanien");
		questionThree.setWrongAnswer2("Italien");
		questionThree.setTopic("Sport");
		questions.add(questionThree);
		
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
