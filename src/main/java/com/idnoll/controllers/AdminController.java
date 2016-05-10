package com.idnoll.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idnoll.models.QuestionModel;
import com.idnoll.services.AdminServiceInterface;


@RestController
@Controller
@RequestMapping(value="")
@Configuration
@ComponentScan("com.idnoll.services")
public class AdminController {

	@Autowired
	private AdminServiceInterface adminServiceInterface;

	@RequestMapping(value="/createQuestion", method = RequestMethod.GET)
	public ModelAndView getQuestion(){
		ModelAndView model = new ModelAndView("addQuestion");
		model.addObject("question", new QuestionModel());
		return model;
	}
	
	@RequestMapping(value="/createQuestion", method = RequestMethod.POST)
	public ModelAndView createQuestion(@ModelAttribute QuestionModel questionModel,
			final RedirectAttributes attributes){
		ModelAndView model = new ModelAndView("redirect:/index.html");
		createQuestion(questionModel);
		attributes.addFlashAttribute("","");
		return model;
	}
	
	@RequestMapping(value="/createQuestion", method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public QuestionModel createQuestion(@RequestBody QuestionModel questionModel){
		return adminServiceInterface.createQuestion(questionModel);
	}
	
	@RequestMapping(value="/editQuestion/{id}", method=RequestMethod.GET)
	public ModelAndView getQuestionToEdit(@PathVariable Long id){
		ModelAndView model = new ModelAndView("editQuestion");
		QuestionModel questionModel = adminServiceInterface.getQuestion(id);
		model.addObject("questionModel",questionModel);
		return model;
	}
	
	@RequestMapping(value="/editQuestion/{id}", method=RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void editQuestion(@PathVariable Long id,
			@RequestBody QuestionModel questionModel){
		questionModel.setId(id);
		adminServiceInterface.updateQuestion(id,questionModel);
	}
	
	@RequestMapping(value="/deleteQuestion/{id}", method=RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public QuestionModel deleteQuestion(@PathVariable Long id)throws Exception{
		return adminServiceInterface.deleteQuestion(id);
	}
	
	@RequestMapping(value="/listOfQuestions", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<QuestionModel> allQuestions(){
		return adminServiceInterface.getAllQuestions();
	}
	
	@RequestMapping(value="/listOfQuestions", method = RequestMethod.GET)
	public ModelAndView listOfQuestions(){
		ModelAndView model = new ModelAndView("listOfQuestions");
		List<QuestionModel> listOfQuestions = new ArrayList<>();
		listOfQuestions.addAll(allQuestions());
		model.addObject("listOfQuestions",listOfQuestions);
		return model;
				
	}
	
}
