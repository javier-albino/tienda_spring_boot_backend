package com.seven.leestore.dto;

import javax.validation.constraints.NotBlank;

public class CiudadDto {
    @NotBlank
	private String nombre;
   
    public CiudadDto() {
    }
    
    public CiudadDto(@NotBlank String nombre) {
    	 this.nombre = nombre;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    
}
