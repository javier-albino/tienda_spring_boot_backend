package com.seven.leestore.dto;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String pass;
    @NotBlank
    private String email;


    public UsuarioDto() {
    }

    public UsuarioDto(@NotBlank String nombre, @NotBlank String pass,@NotBlank String email ) {
        this.nombre = nombre;
        this.pass = pass;
        this.email = email;
     
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
    
    

//    public Float getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(Float precio) {
//        this.precio = precio;
//    }
}
