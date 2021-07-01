package com.mindia.almacen.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mindia.almacen.manager.UsuarioManager;
import com.mindia.almacen.model.Token;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.UsuarioDB;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class InicioController {

	@PostMapping("/login")
	public Token login(@RequestParam("username") String username, @RequestParam("password") String pass) {

		Token token = null;
		if (UsuarioManager.validarCredencialesSys(username, pass)) {

			Usuario user = UsuarioDB.getUsuarioByNombreUsuario(username);
			token = getJWTToken(username, user.getRol().getNombre());
			System.out.println("\nEl usuario " + user.getNombreUsuario() + " inició sesión desde el sistema.\n");

		} else if (UsuarioManager.validarCredenciales(username, pass)) {
			Usuario user = UsuarioDB.getUsuarioByNombreUsuario(username);
			token = getJWTToken(username, user.getRol().getNombre());
			System.out.println(user.getRol().getNombre());
		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		return token;
	}

	private Token getJWTToken(String username, String rol) {
		String id = UUID.randomUUID().toString();
		final int minutos = 60 * 24;
		Date expiration = new Date(System.currentTimeMillis() + minutos * 60 * 1000);

		String secretKey = "Huffm4n";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(rol);

		String tokenStr = Jwts.builder().setId(id).setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		Token token = new Token();
		token.setId(id);
		token.setExpireAt("" + expiration);
		token.setToken(tokenStr);

		return token;
	}

	@GetMapping("/validate")
	public boolean validate() {
		return true;

	}
}
