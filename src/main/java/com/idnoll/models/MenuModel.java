package com.idnoll.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class MenuModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer menu_id;
	
	private String menu_category_name;
	
	@Transient
	private List<UnderCategoryModel> listOfUndercategories = new ArrayList<>();
	
	public MenuModel(){
		
	}

	
	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_category_name() {
		return menu_category_name;
	}

	public void setMenu_category_name(String menu_category_name) {
		this.menu_category_name = menu_category_name;
	}

	public List<UnderCategoryModel> getListOfUndercategories() {
		return listOfUndercategories;
	}

	public void setListOfUndercategories(List<UnderCategoryModel> listOfUndercategories) {
		this.listOfUndercategories = listOfUndercategories;
	}
}
