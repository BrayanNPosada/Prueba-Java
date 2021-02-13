package com.api.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.api.demo.dto.Tabla1Dto;
import com.api.demo.dto.Tabla1Page;
import com.api.demo.entity.Tabla1;
import com.api.demo.interfaces.ITabla1Service;
import com.api.demo.repository.Tabla1Repository;

@Service
public class Tabla1Service implements ITabla1Service {

	@Autowired
	Tabla1Repository tabla1Repository;

	@Override
	public Tabla1Dto GuardarDatos(Tabla1Dto Dto) {
		Tabla1 tabla1 = Map(Dto);
		tabla1 = tabla1Repository.save(tabla1);
		return Map(tabla1);
	}

	@Override
	public List<Tabla1Dto> ProcesarDatos(Tabla1Page Dto) {
		Tabla1 tabla1 = new Tabla1();
		List<Tabla1Dto> Datos = Dto.getListTabla1();
		for (int i = 0; i < Datos.size(); i++) {
			tabla1 = Map(Datos.get(i));
			tabla1 = tabla1Repository.save(tabla1);
		}
		return ConsultarDatos();
	}
	
	@Override
	public List<Tabla1Dto> ConsultarDatos() {
		List<Tabla1Dto> list = new ArrayList<Tabla1Dto>(0);
		List<Tabla1> Tabla1List = tabla1Repository.findAll();
		Tabla1List.forEach(entity -> list.add(Map(entity)));
		return list;
	}
	
	@Override
	public List<Tabla1Dto> ConsultarDatosId(Long Id) {
		List<Tabla1Dto> list = new ArrayList<Tabla1Dto>(0);
		List<Tabla1> Tabla1List = tabla1Repository.findById(Id);
		Tabla1List.forEach(entity -> list.add(Map(entity)));
		return list;
	}

	private Tabla1 Map(Tabla1Dto Dto) {
		Tabla1 tabla1 = new Tabla1();
		try {
			tabla1.setId(Dto.getId());
			tabla1.setNombre(Dto.getNombre());
			tabla1.setApellido(Dto.getApellido());
			tabla1.setStatus(Dto.isStatus());
		} catch (Exception e) {
			System.out.println("Error en el Map por: " + e);
		}
		return tabla1;
	}

	private Tabla1Dto Map(Tabla1 T1) {
		Tabla1Dto Dto = new Tabla1Dto();
		try {
			Dto.setId(T1.getId());
			Dto.setNombre(T1.getNombre());
			Dto.setApellido(T1.getApellido());
			Dto.setStatus(T1.isStatus());
		} catch (Exception e) {
			System.out.println("Error en el Map por: " + e);
		}
		return Dto;
	}

}
