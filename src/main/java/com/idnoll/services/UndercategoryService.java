package com.idnoll.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idnoll.models.CategoryModel;
import com.idnoll.models.UnderCategoryModel;
import com.idnoll.repositories.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import org.springframework.transaction.annotation.Transactional;


import com.idnoll.repositories.UndercategoryRepository;

@Service
public class UndercategoryService {
	
	@Autowired
	private UndercategoryRepository undercategoryRepository;
	
	public UndercategoryService(){
		
	}
	
	@Transactional
	  public List<UnderCategoryModel> getAllCategories() {
	    List<UnderCategoryModel> result = undercategoryRepository.findAll();
	    return result;
	  }
	
	
	public List<UnderCategoryModel> findAllUndercategory(){
		return undercategoryRepository.findAll();
	}


	public UnderCategoryModel findOne(int undercategory_id) {
		return undercategoryRepository.findOne(undercategory_id);
		
	}
	

}
