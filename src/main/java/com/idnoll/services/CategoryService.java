package com.idnoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idnoll.models.CategoryModel;
import com.idnoll.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<CategoryModel> findAllMenuCategory(){
		return categoryRepository.findAll();
	}


	public CategoryModel findOne(int menu_id) {
		return categoryRepository.findOne(menu_id);
		
	}
	

}
