package com.idnoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idnoll.models.MenuModel;
import com.idnoll.repositories.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	
	public List<MenuModel> findAllMenuCategory(){
		return menuRepository.findAll();
	}


	public MenuModel findOne(int menu_id) {
		return menuRepository.findOne(menu_id);
		
	}
	
	
}
