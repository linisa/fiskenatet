package com.idnoll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idnoll.services.MenuService;

@RestController
@Controller
@RequestMapping(value="")
@Configuration
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	
	@RequestMapping("/menu")
	public String menu(){
		return "menu";
	}
	
	@RequestMapping("/undercategoryMenu")
	public String undermenu(){
		return "undercategory menu";
	}	
	
	@RequestMapping("/menus")
	public String menu(Model model){
		model.addAttribute("menus", menuService.findAllMenuCategory());
		return "menus";
	}
	
	@RequestMapping("/menus/{menu_id}")
	public String detail(Model model, @PathVariable int menu_id){
		model.addAttribute("menu", menuService.findOne(menu_id));
		return "menu-detail";
	}
	
}
