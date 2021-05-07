package com.mindia.almacen.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.EquipoManager;
import com.mindia.almacen.pojo.EquipoView;

@RestController
public class EquipoController {
	
	
	@GetMapping("/equipo")
	public List<EquipoView> getAllEquipos() {
		return EquipoManager.listarEquipos();
	}
	
}
