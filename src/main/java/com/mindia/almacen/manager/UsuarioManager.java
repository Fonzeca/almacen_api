package com.mindia.almacen.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import com.mindia.almacen.JWTAuthorizationFilter;
import com.mindia.almacen.model.Area;
import com.mindia.almacen.model.Rol;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.AreaDB;
import com.mindia.almacen.persistence.RolDB;
import com.mindia.almacen.persistence.UsuarioDB;
import com.mindia.almacen.persistence.UsuarioRepository;
import com.mindia.almacen.pojo.LoggedUser;

import io.jsonwebtoken.Claims;

@Service
public class UsuarioManager {

	@Autowired
	UsuarioRepository repo;

	public static List<Usuario> obtenerUsuariosActivos() {
		return UsuarioDB.getUsersActivos();
	}

	public LoggedUser getLoggedUser(String token) {
		String prefix = "Bearer ";
		token = token.replace(prefix, "");

		Claims claims = JWTAuthorizationFilter.validateToken(token);

		String userName = claims.getSubject();

		Usuario usuario = UsuarioDB.getUsuarioByNombreUsuario(userName);

		LoggedUser loggedUser = new LoggedUser();
		loggedUser.setId(usuario.getId().toString());
		loggedUser.setApellido(usuario.getApellido());
		loggedUser.setEmail(usuario.getEmail());
		loggedUser.setEsAdmin(usuario.getRol().getId() > 1);
		loggedUser.setNombre(usuario.getNombre());
		loggedUser.setNombreUsuario(usuario.getNombreUsuario());
		loggedUser.setRol(usuario.getRol().getNombre());

		return loggedUser;
	}

	public static void createUsuario(String username, String rol, String area, String nombre, String apellido,
			String email) {
		Usuario userNuevo = new Usuario();
		userNuevo.setApellido(apellido);
		userNuevo.setEmail(email);
		userNuevo.setNombre(nombre);
		userNuevo.setNombreUsuario(username);

		userNuevo.setRol(RolDB.getRolByNombre(rol));

		userNuevo.setArea(AreaDB.getAreaByNombre(area));
		userNuevo.setActivo(true);
		UsuarioDB.agregarUsuarioNuevo(userNuevo);

	}

	public static void eliminarUsuario(String id) {
		UsuarioDB.eliminarUsuarioById(Integer.parseInt(id));
	}

	public static boolean validarCredenciales(String username, String pass) {
		return UsuarioDB.validar(username, pass);
	}

	public static void editUsuario(int id, String rol, String area, String nombre, String apellido, String email) {
		Rol r = RolDB.getRolByNombre(rol);
		Area a = AreaDB.getAreaByNombre(area);
		UsuarioDB.editarUsuario(id, r, a, nombre, apellido, email);
	}

	public List<String> getUsersLikeNombre(String nombre) {
		List<String> users = new ArrayList<String>();

		if (!StringUtils.hasText(nombre)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
		}

		try {
			List<Usuario> usuarios = repo.obtenerLikeNombreUsuario(nombre);
			for (Usuario u : usuarios) {
				users.add(u.getNombreUsuario());
			}
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
		}

		return users.stream().map(x -> new String(x)).collect(Collectors.toList());
	}

	public static boolean validarCredencialesSys(String username, String pass) {
		return UsuarioDB.validarSys(username, pass);
	}

	public static Usuario getUserByUsername(String username) {
		return UsuarioDB.getUsuarioByNombreUsuario(username);
	}

}
