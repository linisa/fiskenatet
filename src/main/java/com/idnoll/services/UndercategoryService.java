package com.idnoll.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idnoll.models.MenuModel;
import com.idnoll.models.UndercategoryModel;
import com.idnoll.repositories.MenuRepository;

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
	  public List<UndercategoryModel> getAllCategories() {
	    List<UndercategoryModel> result = undercategoryRepository.findAll();
	    return result;
	  }
	
	
	public List<UndercategoryModel> findAllUndercategory(){
		return undercategoryRepository.findAll();
	}


	public UndercategoryModel findOne(int undercategory_id) {
		return undercategoryRepository.findOne(undercategory_id);
		
	}
	

}
