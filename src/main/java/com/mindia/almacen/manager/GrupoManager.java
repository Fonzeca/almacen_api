package com.mindia.almacen.manager;

import com.mindia.almacen.model.GrupoLlaves;
import com.mindia.almacen.persistence.GrupoDB;

public class GrupoManager {

	public static void crearGrupo(GrupoLlaves grupo) {
		GrupoDB.crearGrupo(grupo);
	}

	public static GrupoLlaves getGrupoByNombre(String nombre) {
		GrupoLlaves grupo = GrupoDB.getGrupoByName(nombre);
		return grupo;
	}

}
