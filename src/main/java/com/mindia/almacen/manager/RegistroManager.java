package com.mindia.almacen.manager;

import java.util.Date;
import java.util.List;

import com.mindia.almacen.model.Equipo;
import com.mindia.almacen.model.Registro;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.EquipoDB;
import com.mindia.almacen.persistence.RegistroDB;
import com.mindia.almacen.persistence.UsuarioDB;


public class RegistroManager {

	public static void createRegistro(boolean entrada, int user, int equip) {
		System.out.println("Creando registro");
		Registro registro= new Registro();
		registro.setFecha(new Date());
		registro.setEntrada(entrada);
		
		Equipo equipo=EquipoDB.getEquipoByID(equip);
		Usuario usuario=UsuarioDB.getUsuarioByID(user);
		registro.setEquipo(equipo);
		registro.setUsuario(usuario);
		
		RegistroDB.crearRegistro(registro);
	}

	public static List<Registro> getRegistrosByEquipo(int id) {
		return RegistroDB.getRegistrosByEquipo(id);
	}

	public static List<Registro> getListaRegistros() {
		return RegistroDB.getRegistros();
	}
}
