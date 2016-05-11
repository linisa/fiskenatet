package com.idnoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idnoll.models.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer>{

	
}
