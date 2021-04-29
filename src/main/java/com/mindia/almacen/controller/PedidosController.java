package com.mindia.almacen.controller;

import javax.annotation.security.PermitAll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

	@GetMapping("/")
	@PermitAll
	public String TestApi() {
		return "Hola Mundo!";
	}
}
