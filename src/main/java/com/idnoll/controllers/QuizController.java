package com.idnoll.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.idnoll.models.QuestionModel;

@RestController
@Controller
@RequestMapping(value="")
@Configuration
public class QuizController {
	
	
	
	@RequestMapping(value="/quizPage", method=RequestMethod.GET)
	public ModelAndView quizPage(){
		ModelAndView model = new ModelAndView("quizPage");
		List<QuestionModel> questions = new ArrayList<>();
		questions.add(new QuestionModel("Vad är 1+1","2","3","4","Matte","Addition"));
		model.addObject(questions);
		return model;	
	}

	


	/*public boolean checkIfRightAnswer(Integer i){
		boolean isAnswerCorrect;
		if(questions.get(i).getCorrectAnswer().equals(questions.get(i).getUserAnswer())){
			isAnswerCorrect = true;
		}else{
			isAnswerCorrect = false;
		}
		return isAnswerCorrect;
	}*/
}
