package com.mindia.almacen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.RegistroManager;
import com.mindia.almacen.pojo.RegistroView;

@RestController
public class RegistroController {
	
	@Autowired
	RegistroManager registroManager;
	
	@GetMapping("/registro")
	public List<RegistroView> getAllRegistros() {
		return registroManager.getAllRegistros();
	}
	
	
	
}
