package com.idnoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idnoll.models.MenuModel;
import com.idnoll.models.UndercategoryModel;
import com.idnoll.repositories.MenuRepository;
import com.idnoll.repositories.UndercategoryRepository;

@Service
public class UndercategoryService {
	
	@Autowired
	private UndercategoryRepository undercategoryRepository;
	
	
	public List<UndercategoryModel> findAllUndercategory(){
		return undercategoryRepository.findAll();
	}


	public UndercategoryModel findOne(int undercategory_id) {
		return undercategoryRepository.findOne(undercategory_id);
		
	}
	

}
