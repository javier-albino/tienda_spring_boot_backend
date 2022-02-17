package com.seven.leestore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;

	public Ciudad() {
		
		
	}
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	

	}

	public int getIdCiduad() {
		return id;
	}

	public void setIdCiduad(int id) {
		this.id = id;
	}

	public String getNombreCiudad() {
		return nombre;
	}

	public void setNombreCiudad(String nombre) {
		this.nombre = nombre;
	}
	
	
}
