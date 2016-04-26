package com.idnoll.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.idnoll.models.QuestionModel;


public class QuizController {

	public List<QuestionModel> questions = new ArrayList<>();
	
	static Integer correctAnswers = 0;
	Scanner scan = new Scanner(System.in);

	
	public void run(){
		populateListWithQuestions();
		welcomeMessage();
		chooseCategory();
		for (int i = 0; i < questions.size(); i++) {
			printQuestion(questions.get(i));
			getInput(questions.get(i));
			printAnswer(checkIfRightAnswer(i));
			
		}
		printNumberOfCorrectAnswers();
	}

	private void printAnswer(boolean isAnswerCorrect) {
		if(isAnswerCorrect){
			System.out.println("Det var rätt svar!");
			
		}else{
			System.out.println("Det var fel");
			
		}
		
	}

	private void chooseCategory() {
		System.out.println("Välj en kategori:");
		System.out.println("1. Sport   2.Musik   3.Film");
		String input = scan.nextLine();
		
		if(input.equals("1")){
			System.out.println("Du valde sport");
		}else{
			System.out.println("Du valde sport?");
		}
		
	}

	private void welcomeMessage() {
		System.out.println("###########################################################");
		System.out.println("############"+" Välkommen till våran frågesport! "+"#############" );
		System.out.println("###########################################################");
		
	}

	private void printNumberOfCorrectAnswers() {
		System.out.println();
		System.out.println("Slut på quizen!");
		System.out.println("Du hade " + correctAnswers + " rätta svar");
		
	}

	public void populateListWithQuestions(){
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
		questionTwo.setWrongAnswer2("Conn Smythe Memorial Cup");
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
		System.out.println();
		System.out.println(question.getQuestion());
		System.out.print("(1) "  + question.getCorrectAnswer() + "  (2) "  + question.getWrongAnswer() + "  (3) " + question.getWrongAnswer2()+"\n");
	}

	public void getInput(QuestionModel question){
		
		String input = scan.nextLine();
			if(input.equals("1")){
				question.setUserAnswer(question.getCorrectAnswer());
				correctAnswers++;
			}else if(input.equals("2")){
				question.setUserAnswer(question.getWrongAnswer());
			}else if(input.equals("3")){
				question.setUserAnswer(question.getWrongAnswer2());
			}
	}

	public boolean checkIfRightAnswer(Integer i){
		boolean isAnswerCorrect;
		if(questions.get(i).getCorrectAnswer().equals(questions.get(i).getUserAnswer())){
			isAnswerCorrect = true;
		}else{
			isAnswerCorrect = false;
		}
		return isAnswerCorrect;
	}
}
