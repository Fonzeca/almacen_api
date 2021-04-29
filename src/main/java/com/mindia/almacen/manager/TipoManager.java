package com.mindia.almacen.manager;

import java.util.List;

import com.mindia.almacen.model.Tipo;
import com.mindia.almacen.persistence.TipoDB;


public class TipoManager {
	public static void createTipo(String nombre) {
		Tipo tipo= new Tipo();
		tipo.setNombre(nombre);
		TipoDB.crearTipo(tipo);
	}
	public static List<Tipo> getTipos(){
		return TipoDB.getTipos();
	}
//	public static void editTipo(String idEditar) {
//		int id=Integer.parseInt(idEditar);
//		TipoDB.editarTipo(nombre, idT);
//	}

}
