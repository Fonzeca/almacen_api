package com.mindia.almacen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.GrupoManager;
import com.mindia.almacen.manager.LlaveManager;
import com.mindia.almacen.pojo.GrupoLlaveView;
import com.mindia.almacen.pojo.LlaveView;


@RestController
public class LlaveController {
	
	@Autowired
	LlaveManager llaveManager;
	
	@Autowired
	GrupoManager grupoManager;
	

	@GetMapping("/llave")
	public LlaveView getLlave(@RequestParam("id") String id) {
		return llaveManager.getLlaveByIdentificacion(id);
	}

	@PutMapping("/llave/status")
	public void changeLlaveStatus(@RequestParam("id") String id, @RequestParam("entrada") String entrada) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		@SuppressWarnings("unchecked")
		String username = (String) authentication.getPrincipal();
		
		llaveManager.changeLlaveStatus(id, entrada, username);
	}
	
	@GetMapping("/grupoLlave")
	public GrupoLlaveView getGrupoLlave(@RequestParam("identificacion") String identificacion) {
		return grupoManager.getGrupoLlaveByQr(identificacion);
	}
	
	@GetMapping("/llave/like/{nombre}")
	public List<LlaveView> getLlaveLike(@PathVariable("nombre") String nombre) {
		return llaveManager.getLlavesLikeNombre(nombre);
	}

}
