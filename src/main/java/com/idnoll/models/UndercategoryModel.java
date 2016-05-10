package com.idnoll.models;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class UndercategoryModel implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer undercategory_id;
	
	private String undercategory_menu_name;
	
	@Transient
	private MenuModel menuModel;

	
	public UndercategoryModel(){
		
	}

	public Integer getUndercategory_id() {
		return undercategory_id;
	}


	public void setUndercategory_id(Integer undercategory_id) {
		this.undercategory_id = undercategory_id;
	}


	public String getUndercategory_menu_name() {
		return undercategory_menu_name;
	}


	public void setUndercategory_menu_name(String undercategory_menu_name) {
		this.undercategory_menu_name = undercategory_menu_name;
	}


	public MenuModel getMenuModel() {
		return menuModel;
	}


	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
	
	
	
	
	

}
