package com.api.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.dto.Tabla1Dto;
import com.api.demo.dto.Tabla1Page;
import com.api.demo.interfaces.ITabla1Service;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/info")
public class Tabla1Controller {

	@Autowired
	ITabla1Service iTabla1Service;

	@PostMapping("/GuardarInfo")
	public ResponseEntity<Object> GuardarInfo(@RequestBody Tabla1Dto Dto) throws Exception {
		Tabla1Dto response = new Tabla1Dto();
		try {
			response = iTabla1Service.GuardarDatos(Dto);
		} catch (Exception e) {
			System.out.println("Error al guardar la informacion por: " + e);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/listarDatos")
	public ResponseEntity<Object> listarDatos() throws Exception {
		Tabla1Page response = new Tabla1Page();
		try {
			List<Tabla1Dto> dtos = iTabla1Service.ConsultarDatos();
			response.setListTabla1(dtos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/listarDatos/{idDato}")
	public ResponseEntity<Object> listarDatosId(@PathVariable("idDato") Long idDato) throws Exception {
		Tabla1Page response = new Tabla1Page();
		try {
			List<Tabla1Dto> dtos = iTabla1Service.ConsultarDatosId(idDato);
			response.setListTabla1(dtos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping("/ProcesarDatos")
	public ResponseEntity<Object> ProcesarDatos(@RequestBody Tabla1Page Dto) throws Exception {
		Tabla1Page response = new Tabla1Page();
		try {

			for (int i = 0; i < Dto.getListTabla1().size(); i++) {
				if (Dto.getListTabla1().get(i).getId() != null) {
					List<Tabla1Dto> dtos = iTabla1Service.ProcesarDatos(Dto);
					response.setListTabla1(dtos);
				}
			}
		} catch (Exception e) {
			System.out.println("Error al guardar la informacion por: " + e);
		}
		return ResponseEntity.ok(response);
	}

}
