package com.idnoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idnoll.models.MenuModel;

public interface MenuRepository extends JpaRepository<MenuModel, Integer>{

	
}
