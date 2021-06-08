package com.mindia.almacen.manager;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindia.almacen.manager.RegistroManager.TIPO_REGISTRO;
import com.mindia.almacen.model.Equipo;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.EquipoDB;
import com.mindia.almacen.persistence.LugarDB;
import com.mindia.almacen.persistence.TipoDB;
import com.mindia.almacen.persistence.UsuarioDB;
import com.mindia.almacen.pojo.EquipoView;

@Service
public class EquipoManager {

	@Autowired
	RegistroManager registroManager;
	
	public void createEquipo(String serial, String nombre, String tipo, String lugar, String modelo,
			String usuario, String observaciones, String accesorios, Usuario userActual) {
		Equipo equipo = new Equipo();
		equipo.setLugar(LugarDB.getLugarByNombre(lugar));
		equipo.setTipo(TipoDB.getTipoByNombre(tipo));
		equipo.setNombre(nombre);

		if (serial == null) {
			equipo.setSerial("N/A");
		} else
			equipo.setSerial(serial);

		if (modelo == null) {
			equipo.setModelo("N/A");
		} else
			equipo.setModelo(modelo);

		if (usuario != null) {
			equipo.setUsuario(UsuarioDB.getUsuarioByNombreUsuario(usuario));
		}
		if (observaciones == null) {
			equipo.setObservaciones("N/A");
		} else
			equipo.setObservaciones(observaciones);

		if (accesorios == null) {
			equipo.setAccesorios("N/A");
		} else
			equipo.setAccesorios(accesorios);

		equipo.setEstado("Disponible");

		Serializable idS = EquipoDB.crearEquipo(equipo);
		int id = (int) idS;
		Equipo e = EquipoDB.getEquipoByID(id);
		System.out.println(e.getNombre());

		
		registroManager.createRegistro(true, userActual.getId(), TIPO_REGISTRO.EQUIPO, e.getEquipoId());
	}

	public void changeStatus(String user, int id) {
		System.out.println("Cambiando el estado del equipo numero " + id);

		Usuario usuario = UsuarioDB.getUsuarioByNombreUsuario(user);
		
		Equipo equipo = EquipoDB.getEquipoByID(id);
		
		if (equipo.getEstado().equals("En uso")) {
			registroManager.createRegistro(true, usuario.getId(), TIPO_REGISTRO.EQUIPO, equipo.getEquipoId());
			equipo.setEstado("Disponible");
		} else {
			registroManager.createRegistro(false, usuario.getId(), TIPO_REGISTRO.EQUIPO, equipo.getEquipoId());
			equipo.setEstado("En uso");
		}

		EquipoDB.cambiarEstado(equipo);
	}

	public static List<EquipoView> listarEquipos() {

		// OJO: devuelve todos los equipos, tener en cuenta paginado o busqueda like
		List<Equipo> equipos = EquipoDB.getListaEquipos();

		List<EquipoView> views = equipos.stream().map(x -> new EquipoView(x)).collect(Collectors.toList());

		return views;

//		return EquipoDB.getListaEquipos().stream().map(x -> new EquipoView(x)).collect(Collectors.toList());
	}

	public static List<Equipo> listarTodosEquipos() {
		return EquipoDB.getListaEquiposCompleta();
	}

	public static EquipoView getEquipo(int id) {
		Equipo equipo = EquipoDB.getEquipoByID(id);
		EquipoView equipoView = new EquipoView(equipo);

		return equipoView;
	}
}
