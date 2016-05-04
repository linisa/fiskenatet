package com.idnoll.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UndercategoryModel {
	
	@Id
	@GeneratedValue
	private Integer undercategory_id;
	
	@Column(name="undercategory_menu_name")
	private String undercategory_menu_name;
	
	
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private MenuModel menuModel;


	@OneToMany(mappedBy="question_id")
	private List<QuestionModel> listOfQuestions;
	
	
	


	public List<QuestionModel> getListOfQuestions() {
		return listOfQuestions;
	}


	public void setListOfQuestions(List<QuestionModel> listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
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
