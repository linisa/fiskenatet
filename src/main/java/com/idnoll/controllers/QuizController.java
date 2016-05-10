package com.idnoll.controllers;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.security.cert.CertPathChecker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idnoll.models.QuestionModel;


@RestController
@Controller
@RequestMapping(value="")
@Configuration
public class QuizController {
	
	public List<QuestionModel> questions;
	
	
	
	
	@RequestMapping(value="/quizPage", method=RequestMethod.GET)
	public ModelAndView quizPage(){
		ModelAndView model = new ModelAndView("quizPage");
		questions = new ArrayList<>();
		questions.add(new QuestionModel("Vad är 1+1","2","3","4","Matte",0L));
		model.addObject("questions",questions);
		return model;	
	}
	
	
	@RequestMapping(value="/quizPage", method=RequestMethod.POST)
	public ModelAndView showTotalCorrectAnswers(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws IOException{
		List<String> answers = new ArrayList<>();
		ModelAndView maw = new ModelAndView("numberOfCorrectAnswersInQuiz");
		for (int i = 0; i < questions.size(); i++) {
			answers.add(request.getParameter("answer"+i));
		}		
		Integer[] correctAndTotalAnswers = {checkNumberOfRightAnswers(answers), questions.size()};
		System.out.println(checkNumberOfRightAnswers(answers));
		System.out.println(questions.size());
		maw.addObject("correctAndTotalAnswers", correctAndTotalAnswers);
		return maw;
		
	}


	public Integer checkNumberOfRightAnswers(List<String> userAnswers){
		
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
