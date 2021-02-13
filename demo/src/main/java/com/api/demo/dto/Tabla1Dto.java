package com.api.demo.dto;

public class Tabla1Dto {

	Long Id;
	String Nombre;
	String Apellido;
	boolean status;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
