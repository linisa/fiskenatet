package com.idnoll.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.idnoll.models.QuestionModel;


@RestController
@Controller
@RequestMapping(value="")
@Configuration
public class QuizController {
	
	List<QuestionModel> questions = new ArrayList<>();
	
	
	
	
	@RequestMapping(value="/quizPage", method=RequestMethod.GET)
	public ModelAndView quizPage(){
		ModelAndView model = new ModelAndView("quizPage");
		questions.add(new QuestionModel("Vad är 1+1","2","3","4","Matte",0L));
		/*Map<String, Object> models = new HashMap<>();
		models.put("userAnswerArray", answers);
		models.put("questions", questions);*/
		model.addObject("questions",questions);
		return model;	
	}
	
	
	@RequestMapping(value="/quizPage", method=RequestMethod.POST)
	public void setAnswer(HttpServletRequest request){
		List<String> answers = new ArrayList<>();
		for (int i = 0; i < questions.size(); i++) {
			answers.add(request.getParameter("answer"+i));
		}
		
		for (int i = 0; i < answers.size(); i++) {
			System.out.println("ANSWERS METODEN:" + answers.get(i));
		}
		
		checkNumberOfRightAnswers(answers);
		
	}

	public Integer checkNumberOfRightAnswers( List<String> userAnswers){
		
		int correctAnswerCounter = 0;
		
		for (int i = 0; i < userAnswers.size(); i++) {
			
			if(questions.get(0).getCorrectAnswer().equals(userAnswers.get(0))){
			correctAnswerCounter ++;
			}
		}
		System.out.println("HUR MÅNGA RÄTT:" + correctAnswerCounter);
		return correctAnswerCounter;
		
	}
}
