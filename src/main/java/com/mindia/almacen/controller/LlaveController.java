package com.mindia.almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.LlaveManager;
import com.mindia.almacen.pojo.LlaveView;


@RestController
public class LlaveController {
	
	@Autowired
	LlaveManager llaveManager;
	

	@GetMapping("/llave")
	public LlaveView getLlave(@RequestParam("id") String id) {
		return llaveManager.getLlaveByIdentificacion(id);
	}

	@GetMapping("/llave/change")
	public void changeLlaveStatus(@RequestParam("id") String id, @RequestParam("entrada") String entrada) {
		llaveManager.changeLlaveStatus(id, entrada);
	}
	
	@GetMapping("/grupoLlave")
	public void getAllGrupoLlave(@RequestParam("identificacion") String identificacion, @RequestParam("entrada") String entrada) {
	}

}
