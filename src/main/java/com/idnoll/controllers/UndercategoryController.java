package com.idnoll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idnoll.services.UndercategoryService;

@Controller
@RequestMapping("/")
public class UndercategoryController {

	@Autowired 
	private UndercategoryService undercategoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	  public String listAllUndercategories(Model model) {
	   model.addAttribute("undercategories", undercategoryService.getAllCategories());
	    return "home";
	}
}
