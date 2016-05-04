package com.idnoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idnoll.models.MenuModel;
import com.idnoll.models.UndercategoryModel;

public interface UndercategoryRepository extends JpaRepository<UndercategoryModel, Integer>{

	
}
