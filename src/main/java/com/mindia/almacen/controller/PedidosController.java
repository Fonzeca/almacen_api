package com.mindia.almacen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

	@GetMapping("/")
	public String TestApi() {
		return "Hola Mundo!";
	}
}
