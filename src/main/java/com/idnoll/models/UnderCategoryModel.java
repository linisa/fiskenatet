package com.idnoll.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class UnderCategoryModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer underCategory_id;
	
	
	private String underCategoryName;
	private int category;

	
	public UnderCategoryModel(){
		
	}


	public Integer getUnderCategory_id() {
		return underCategory_id;
	}

	public String getUnderCategoryName() {
		return underCategoryName;
	}


	public void setUnderCategoryName(String underCategoryName) {
		this.underCategoryName = underCategoryName;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}

	
}
