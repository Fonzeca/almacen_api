package com.mindia.almacen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistroController {
	
	
	@GetMapping("/registros")
	public void getAllRegistros(@RequestParam int equipoId) {
		
		
		
	}
	
	
}
