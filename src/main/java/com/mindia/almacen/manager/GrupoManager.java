package com.mindia.almacen.manager;

import com.mindia.almacen.model.Grupo;
import com.mindia.almacen.persistence.GrupoDB;

public class GrupoManager {

	public static void crearGrupo(Grupo grupo) {
		GrupoDB.crearGrupo(grupo);
	}

	public static Grupo getGrupoByNombre(String nombre) {
		Grupo grupo = GrupoDB.getGrupoByName(nombre);
		return grupo;
	}

}
