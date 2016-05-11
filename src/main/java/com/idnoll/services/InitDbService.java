package com.idnoll.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idnoll.models.CategoryModel;
import com.idnoll.models.QuestionModel;
import com.idnoll.models.UnderCategoryModel;
import com.idnoll.repositories.CategoryRepository;
import com.idnoll.repositories.UndercategoryRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private CategoryRepository menuRepository;
	
	@Autowired
	private UndercategoryRepository undercategoryRepository;
	
	@PostConstruct
	public void init(){
		//THIS IS MEANT TO BE USED WHEN THE ADMIN WANTS TO CREATE NEW CATEGORIES AND UNDERCATEGORIES
//		MenuModel categoryMenu = new MenuModel();
//		categoryMenu.setCategories_name("Sport");
//		menuRepository.save(categoryMenu);
//		
//		MenuModel menuCategory = new MenuModel();
//		menuCategory.setCategories_name("Geografi");
//		menuRepository.save(menuCategory);
//		
//		UndercategoryModel undercategoryMenu = new UndercategoryModel();
//		undercategoryMenu.setUndercategories_name("Skandinavien");
//		List<UndercategoryModel> undercategories = new ArrayList<UndercategoryModel>();
//		undercategories.add(undercategoryMenu);
//		undercategoryRepository.save(undercategoryMenu);
	}
}
