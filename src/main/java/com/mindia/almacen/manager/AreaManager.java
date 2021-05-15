package com.mindia.almacen.manager;

import com.mindia.almacen.model.Area;
import com.mindia.almacen.persistence.AreaDB;
import com.mindia.almacen.persistence.UsuarioDB;

public class AreaManager {
	
	public static void createArea(String nombre, String user) {
		Area area=new Area();
		area.setNombre(nombre);
		area.setUsuario(UsuarioDB.getUsuarioByNombreUsuario(user));
		AreaDB.agregarAreaNueva(area);
	}

	public static void EditArea(String id, String nombre, String user) {
		int idI=Integer.valueOf(id);
		AreaDB.editarArea(idI,nombre,user);
		
	}

}
