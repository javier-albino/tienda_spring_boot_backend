package com.seven.leestore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String pass;
	private String email;



	public Usuario() {
	}

	public Usuario(String nombre, String pass, String email) {
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

//	public float getPrecio() {
//		return precio;
//	}
//
//	public void setPrecio(float precio) {
//		this.precio = precio;
//	}
}
