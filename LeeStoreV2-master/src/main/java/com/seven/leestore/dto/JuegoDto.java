package com.seven.leestore.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class JuegoDto {
	
	  @NotBlank
	    private String nombre;
	    @NotBlank
	    private String genero;
	    @NotBlank
	    @Min(0)
	    private float precio;
	    
	    public JuegoDto() {
	    }
	    
	    public JuegoDto(@NotBlank String nombre, @NotBlank String genero, @Min(0) Float precio) {
	        this.nombre = nombre;
	        this.genero = genero;
	        this.precio = precio;
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			this.precio = precio;
		}

	    
	    
}
