package com.mindia.almacen.manager;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.mindia.almacen.model.Equipo;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.EquipoDB;
import com.mindia.almacen.persistence.LugarDB;
import com.mindia.almacen.persistence.RegistroDB;
import com.mindia.almacen.persistence.TipoDB;
import com.mindia.almacen.persistence.UsuarioDB;
import com.mindia.almacen.pojo.EquipoView;


public class EquipoManager {
	
	public static void createEquipo(String serial, String nombre, String tipo, String lugar, String modelo, String usuario,
			String observaciones, String accesorios,Usuario userActual) {
		Equipo equipo= new Equipo();
		equipo.setLugar(LugarDB.getLugarByNombre(lugar));
		equipo.setTipo(TipoDB.getTipoByNombre(tipo));
		equipo.setNombre(nombre);
		
		
		if(serial==null) {
			equipo.setSerial("N/A");
		}else equipo.setSerial(serial);
		
		
		
		if(modelo==null) {
			equipo.setModelo("N/A");
		}else equipo.setModelo(modelo);
		
		
		if(usuario!=null) {
			equipo.setUsuario(UsuarioDB.getUsuarioByNombreUsuario(usuario));
		}
		if(observaciones==null) {
			equipo.setObservaciones("N/A");
		}else equipo.setObservaciones(observaciones);
		
		if(accesorios==null) {
			equipo.setAccesorios("N/A");
		}else equipo.setAccesorios(accesorios);
		
		equipo.setEstado("Disponible");
		
		
		Serializable idS=EquipoDB.crearEquipo(equipo);
		int id=(int) idS;
		Equipo e=EquipoDB.getEquipoByID(id);
		System.out.println(e.getNombre());
		
		
		RegistroDB.crearRegistro(e,userActual);
		
	}
	public static void changeStatus(String user,int id, boolean enUso) {
		System.out.println("Cambiando el estado del equipo numero "+id+ " a en uso en " + enUso);
		
		Usuario usuario = UsuarioDB.getUsuarioByID(id);
		
		EquipoDB.cambiarEstado(usuario.getUsuarioId(), id, enUso);
	}
	
	public static List<EquipoView> listarEquipos() {
		
		//OJO: devuelve todos los equipos, tener en cuenta paginado o busqueda like
		List<Equipo> equipos = EquipoDB.getListaEquipos();
		
		List<EquipoView> views = equipos.stream()
									.map(x -> new EquipoView(x))
									.collect(Collectors.toList());
		
		return views;
		
//		return EquipoDB.getListaEquipos().stream().map(x -> new EquipoView(x)).collect(Collectors.toList());
	}
	
	public static  List<Equipo> listarTodosEquipos(){
		return EquipoDB.getListaEquiposCompleta();
	}
	public static Equipo getEquipo(int id) {
		return EquipoDB.getEquipoByID(id);
	}
}
