package com.idnoll.main;

import com.idnoll.controllers.QuizController;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		QuizController quizController = new QuizController();
		quizController.run();
	}

}
