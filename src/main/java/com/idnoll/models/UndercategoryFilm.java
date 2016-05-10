package com.idnoll.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="undercategories_name")
public class UndercategoryFilm implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_undercategory_film")
	private int id_undercategory_film;
	
	private String film_undercategory;

	
	
	public int getId_undercategory_film() {
		return id_undercategory_film;
	}

	public void setId_undercategory_film(int id_undercategory_film) {
		this.id_undercategory_film = id_undercategory_film;
	}

	public String getFilm_undercategory() {
		return film_undercategory;
	}
	
	
	
}
