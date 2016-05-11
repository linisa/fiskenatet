package com.idnoll.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="categories")
public class CategoryModel implements Serializable{

	@Id
	@GeneratedValue
	private Integer categories_id;

	private String categories_name;

	@Transient
	private List<UnderCategoryModel> listOfUnderCategories = new ArrayList<>();

	public CategoryModel(){

	}

	public String getCategories_name() {
		return categories_name;
	}

	public void setCategories_name(String categories_name) {
		this.categories_name = categories_name;
	}

	public List<UnderCategoryModel> getListOfUnderCategories() {
		return listOfUnderCategories;
	}

	public void setListOfUndercategories(List<UnderCategoryModel> listOfUndercategories) {
		this.listOfUnderCategories = listOfUndercategories;
	}

	public Integer getCategories_id() {
		return categories_id;
	}


	

}
