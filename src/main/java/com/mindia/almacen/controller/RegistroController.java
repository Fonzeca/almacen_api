package com.mindia.almacen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.RegistroManager;

@RestController
public class RegistroController {
	
	
	@GetMapping("/registro")
	public void getAllRegistros(@RequestParam int equipoId) {
		RegistroManager.getRegistrosByEquipo(equipoId);
	}
	
	
}
