package com.idnoll.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class NavigationController {

	@RequestMapping(value={"/","index"}, method = RequestMethod.GET)
	public ModelAndView indexPage(){
		return new ModelAndView("index");
	}
	
}
