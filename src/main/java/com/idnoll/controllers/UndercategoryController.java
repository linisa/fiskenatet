package com.idnoll.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.idnoll.services.UndercategoryService;
import com.idnoll.models.*;

@RestController
@Controller
@RequestMapping(value="")
@Configuration
public class UndercategoryController {
	
	List<UnderCategoryModel> undercategories;

	@Autowired 
	private UndercategoryService undercategoryService;
	
	@RequestMapping(value="/undercategory", method = RequestMethod.GET)
	  public ModelAndView listAllUndercategories() {
		ModelAndView maw = new ModelAndView("undercategory");
		undercategories = undercategoryService.getAllCategories();
	   maw.addObject("undercategories", undercategories);
	    return maw;
	}
}
