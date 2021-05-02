package com.mindia.almacen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.UsuarioManager;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.pojo.LoggedUser;
import com.mindia.almacen.pojo.UsuarioView;

@RestController
public class UsersController {

	
	@GetMapping("/users")
	public List<UsuarioView> getAllUsers() {
		List<UsuarioView> list = new ArrayList<UsuarioView>();
		
		for(Usuario u : UsuarioManager.obtenerUsuariosActivos()) {
			UsuarioView user = new UsuarioView();
			user.setNombreUsuario(u.getNombreUsuario());
			user.setNombre(u.getNombre());
			user.setApellido(u.getApellido());
			list.add(user);
		}
		
		return list;
	}
	
	@GetMapping("/loggedUser")
	public LoggedUser getLoggedUser(@RequestHeader("Authorization") String token) {
		return UsuarioManager.getLoggedUser(token);
	}
}
