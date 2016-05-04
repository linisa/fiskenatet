package com.idnoll.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idnoll.models.MenuModel;
import com.idnoll.models.QuestionModel;
import com.idnoll.models.UndercategoryModel;
import com.idnoll.repositories.MenuRepository;
import com.idnoll.repositories.UndercategoryRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private UndercategoryRepository undercategoryRepository;
	
	@Autowired
	private QuestionModel questionRepository;
	
	@PostConstruct
	public void init(){
		MenuModel categoryMenu = new MenuModel();
		categoryMenu.setMenu_category_name("Sport");
		menuRepository.save(categoryMenu);
		
		MenuModel menuCategory = new MenuModel();
		menuCategory.setMenu_category_name("Geografi");
		menuRepository.save(menuCategory);
		
		UndercategoryModel undercategoryMenu = new UndercategoryModel();
		undercategoryMenu.setUndercategory_menu_name("Geografi");
		List<UndercategoryModel> undercategories = new ArrayList<UndercategoryModel>();
		undercategories.add(undercategoryMenu);
		undercategoryRepository.save(undercategoryMenu);
	}
}
