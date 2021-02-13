package com.api.demo.interfaces;

import java.util.List;

import com.api.demo.dto.Tabla1Dto;
import com.api.demo.dto.Tabla1Page;

public interface ITabla1Service {

	public Tabla1Dto GuardarDatos(Tabla1Dto Dto);
	
	public List<Tabla1Dto> ProcesarDatos(Tabla1Page Dto);
	
	public List<Tabla1Dto> ConsultarDatos();

	public List<Tabla1Dto> ConsultarDatosId(Long Id);
	
}
