package com.mindia.almacen.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindia.almacen.manager.RegistroManager.TIPO_REGISTRO;
import com.mindia.almacen.model.Equipo;
import com.mindia.almacen.model.Registro;
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

	public void createEquipo(String serial, String nombre, String tipo, String lugar, String modelo, String usuario,
			String observaciones, String accesorios, Usuario userActual) {
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

		registroManager.createRegistro(true, userActual.getId(), TIPO_REGISTRO.EQUIPO, e.getEquipoId(), null);
	}

	public void changeStatus(String user, int id) {
		System.out.println("Cambiando el estado del equipo numero " + id);

		Usuario usuario = UsuarioDB.getUsuarioByNombreUsuario(user);

		Equipo equipo = EquipoDB.getEquipoByID(id);

		if (equipo.getEstado().equals("En uso")) {
			registroManager.createRegistro(true, usuario.getId(), TIPO_REGISTRO.EQUIPO, equipo.getEquipoId(), null);
			equipo.setEstado("Disponible");
		} else {
			registroManager.createRegistro(false, usuario.getId(), TIPO_REGISTRO.EQUIPO, equipo.getEquipoId(), null);
			equipo.setEstado("En uso");
		}

		EquipoDB.cambiarEstado(equipo);
	}

	public static List<EquipoView> listarEquipos() {

		// OJO: devuelve todos los equipos, tener en cuenta paginado o busqueda like
		List<Equipo> equipos = EquipoDB.getListaEquipos();

		List<EquipoView> views = equipos.stream().map(x -> new EquipoView(x)).collect(Collectors.toList());
		List<Integer> ids = new ArrayList<Integer>();
		for (Equipo equipo : equipos) {
			ids.add(equipo.getEquipoId());
		}
		List<Registro> registros = RegistroManager.getLastRegistrosByEntidadAndId(TIPO_REGISTRO.EQUIPO, ids);
		for (int index = 0; index < registros.size(); index++) {
			views.get(index).setUsuario(registros.get(index).getUsuarioByUsuario().getNombreUsuario());
		}

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

	public List<EquipoView> listarEquiposPropios(String username) {
		Usuario user = UsuarioManager.getUserByUsername(username);
		List<Equipo> equipos = EquipoDB.getListaEquiposByUsuario(user);
		List<EquipoView> returnEquipos = new ArrayList<EquipoView>();
		List<Integer> ids = new ArrayList<Integer>();
		for (Equipo equipo : equipos) {
			ids.add(equipo.getEquipoId());
		}
		List<Registro> registros = RegistroManager.getLastRegistrosByEntidadAndId(TIPO_REGISTRO.EQUIPO, ids);
		for (int i = 0; i < registros.size(); i++) {
			if (registros.get(i).getEntrada() == false) {
				returnEquipos.add(new EquipoView(equipos.get(i)));
			}
		}
		return returnEquipos;
	}
}
