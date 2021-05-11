package com.mindia.almacen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.LlaveManager;
import com.mindia.almacen.pojo.LlaveView;

@RestController
public class LlaveController {

	@GetMapping("/llave")
	public LlaveView getLlave(@RequestParam("identificacion") String identificacion) {
		return LlaveManager.getLlaveByIdentificacion(identificacion);

	}

	@GetMapping("/llave/change")
	public void changeLlaveStatus(@RequestParam("identificacion") String identificacion,
			@RequestParam("entrada") String entrada) {
		LlaveManager.changeStatus(identificacion, entrada);
	}

}
