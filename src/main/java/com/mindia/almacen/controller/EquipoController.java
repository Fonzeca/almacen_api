package com.mindia.almacen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.JWTAuthorizationFilter;
import com.mindia.almacen.manager.EquipoManager;
import com.mindia.almacen.manager.GrupoManager;
import com.mindia.almacen.pojo.EquipoView;
import com.mindia.almacen.pojo.GrupoEquipoView;

import io.jsonwebtoken.Claims;

@RestController
public class EquipoController {

	@Autowired
	GrupoManager grupoManager;

	@Autowired
	EquipoManager equipoManager;

	@GetMapping("/equipo")
	public List<EquipoView> getAllEquipos() {
		return EquipoManager.listarEquipos();
	}

	@GetMapping("/equipo/propios")
	public List<EquipoView> getEquiposPropios(@RequestHeader("Authorization") String token) {
		String prefix = "Bearer ";
		token = token.replace(prefix, "");

		Claims claims = JWTAuthorizationFilter.validateToken(token);

		String username = claims.getSubject();
		return equipoManager.listarEquiposPropios(username);
	}

	@GetMapping("/equipo/detalle")
	public EquipoView getAllDetalleEquipo(@RequestParam("id") int id) {
		return EquipoManager.getEquipo(id);
	}

	@PutMapping("/equipo/status")
	public void changeEquipoStatus(@RequestParam int id) {
		String prefix = "Bearer ";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		@SuppressWarnings("unchecked")
		String username = (String) authentication.getPrincipal();

		equipoManager.changeStatus(username, id);
	}

	@GetMapping("/grupoEquipo")
	public GrupoEquipoView getGrupoEquipo(@RequestParam("identificacion") String identificacion) {
		return grupoManager.getGrupoEquipoByQr(identificacion);
	}

	@GetMapping("/grupoEquipo/status")
	public void changeGrupoStatus(@RequestParam("id") String id, @RequestParam("entrada") String entrada) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		@SuppressWarnings("unchecked")
		String username = (String) authentication.getPrincipal();

		grupoManager.changeStatusGrupoEquipo(id, entrada, username);
	}
}
