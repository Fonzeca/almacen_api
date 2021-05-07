package com.mindia.almacen.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.JWTAuthorizationFilter;
import com.mindia.almacen.manager.EquipoManager;
import com.mindia.almacen.pojo.EquipoView;

import io.jsonwebtoken.Claims;

@RestController
public class EquipoController {
	
	
	@GetMapping("/equipo")
	public List<EquipoView> getAllEquipos() {
		return EquipoManager.listarEquipos();
	}
	
	@PutMapping
	public void changeEquipoStatus(@RequestParam boolean enUso, @RequestParam int id, @RequestHeader("Authorization") String token) {
		String prefix = "Bearer ";
		token = token.replace(prefix, "");
		
		Claims claims = JWTAuthorizationFilter.validateToken(token);
		
		String userName = claims.getSubject();
		
		EquipoManager.changeStatus(userName, id, enUso);
	}
	
}
