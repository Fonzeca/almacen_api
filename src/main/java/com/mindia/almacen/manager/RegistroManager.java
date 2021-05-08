package com.mindia.almacen.manager;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mindia.almacen.model.Equipo;
import com.mindia.almacen.model.Registro;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.EquipoDB;
import com.mindia.almacen.persistence.RegistroDB;
import com.mindia.almacen.persistence.UsuarioDB;
import com.mindia.almacen.pojo.RegistroView;


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

	public static List<RegistroView> getRegistrosByEquipo(int id) {
		
		List<Registro> registros = RegistroDB.getRegistrosByEquipo(id);
		
		List<RegistroView> views = registros.stream()
									.map(x -> new RegistroView(x))
									.collect(Collectors.toList());
		return views;
	}

	public static List<Registro> getListaRegistros() {
		return RegistroDB.getRegistros();
	}
}
