package com.api.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Tabla1")
@NamedQueries({ @NamedQuery(name = "Tabla1.findAll", query = "SELECT t FROM Tabla1 t") })
public class Tabla1 implements Serializable {


	private static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "Nombre")
	private String Nombre;
	
	@Column(name = "Apellido")
	private String Apellido;
	
	@Column(name = "status")
	private boolean status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
