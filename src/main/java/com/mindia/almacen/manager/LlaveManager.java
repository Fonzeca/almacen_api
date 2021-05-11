package com.mindia.almacen.manager;

import com.mindia.almacen.model.Llave;
import com.mindia.almacen.persistence.LlaveDB;
import com.mindia.almacen.pojo.LlaveView;

public class LlaveManager {

	public static void crearLlave(Llave llave) {
		LlaveDB.crearLlave(llave);
	}

	public static LlaveView getLlaveByIdentificacion(String identificacion) {
		String[] ident = identificacion.split("-");
		String nombre = ident[0];
		String idS = ident[1];
		Integer id = Integer.parseInt(idS);
		var llave = LlaveDB.getLlaveByIdentificacion(id, nombre);
		LlaveView llaveView = new LlaveView(llave);
		return llaveView;
	}

}
