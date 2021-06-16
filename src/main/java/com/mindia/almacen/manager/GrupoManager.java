package com.mindia.almacen.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mindia.almacen.manager.RegistroManager.TIPO_REGISTRO;
import com.mindia.almacen.model.Equipo;
import com.mindia.almacen.model.GrupoEquipos;
import com.mindia.almacen.model.GrupoLlaves;
import com.mindia.almacen.model.Llave;
import com.mindia.almacen.model.Registro;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.GrupoEquipoRepository;
import com.mindia.almacen.persistence.GrupoLlaveRepository;
import com.mindia.almacen.persistence.UsuarioDB;
import com.mindia.almacen.pojo.GrupoEquipoView;
import com.mindia.almacen.pojo.GrupoLlaveView;
import com.mindia.almacen.utils.QrId;

@Service
public class GrupoManager {

	@Autowired
	GrupoLlaveRepository grupoLlaveRepo;

	@Autowired
	GrupoEquipoRepository grupoEquipoRepo;

	@Autowired
	RegistroManager registroManager;

	@Autowired
	LlaveManager llaveManager;

	@Autowired
	EquipoManager equipoManager;

	public GrupoLlaveView getGrupoLlaveByQr(String identificacion) {
		QrId qrId = new QrId(identificacion);

		GrupoLlaves grupoLlave = grupoLlaveRepo.obtenerByIdentificacion(qrId.id, qrId.value);

		if (grupoLlave == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de llaves no encontrada");
		}

		return new GrupoLlaveView(grupoLlave);
	}

	public GrupoLlaveView getGrupoLlaveById(int id) {
		GrupoLlaves grupoLlave = grupoLlaveRepo.getOne(id);

		if (grupoLlave == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de llaves no encontrada");
		}

		return new GrupoLlaveView(grupoLlave);
	}

	public GrupoEquipoView getGrupoEquipoByQr(String identificacion) {
		QrId qrId = new QrId(identificacion);

		GrupoEquipos grupoEquipo = grupoEquipoRepo.obtenerByIdentificacion(qrId.id, qrId.value);

		if (grupoEquipo == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de equipos no encontrada");
		}

		return new GrupoEquipoView(grupoEquipo);
	}

	public GrupoEquipoView getGrupoEquipoById(int id) {
		GrupoEquipos grupoEquipo = grupoEquipoRepo.getOne(id);

		if (grupoEquipo == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de equipos no encontrada");
		}

		return new GrupoEquipoView(grupoEquipo);
	}

	public void changeStatusGrupoLlave(String id, String entrada, String username, String guardia) {
		GrupoLlaves grupoLlaves = grupoLlaveRepo.getOne(Integer.parseInt(id));
		List<Integer> ids = new ArrayList<Integer>();
		for (Llave llave : grupoLlaves.getLlaves()) {
			ids.add(llave.getLlaveId());
			llaveManager.changeLlaveStatus(llave.getLlaveId().toString(), entrada, username, guardia);
		}
		grupoLlaveRepo.save(grupoLlaves);
		Usuario encargado = UsuarioDB.getUsuarioByNombreUsuario(guardia);
		int idEntidad = Integer.parseInt(id);
		Usuario usuario = null;
		if (entrada.equals("En uso")) {
			List<Registro> registros = RegistroManager.getLastRegistrosByEntidadAndId(TIPO_REGISTRO.LLAVE, ids);
			usuario = registros.get(0).getUsuarioByUsuario();
			registroManager.createRegistro(false, usuario.getId(), TIPO_REGISTRO.GRUPO_LLAVE, idEntidad, encargado);
		} else {
			usuario = UsuarioDB.getUsuarioByNombreUsuario(username);
			registroManager.createRegistro(true, usuario.getId(), TIPO_REGISTRO.GRUPO_LLAVE, idEntidad, encargado);
		}
	}

	public void changeStatusGrupoEquipo(String id, String entrada, String user) {
		GrupoEquipos grupo = grupoEquipoRepo.getOne(Integer.parseInt(id));
		for (Equipo equipo : grupo.getEquipos()) {
			equipoManager.changeStatus(user, equipo.getEquipoId());
		}
		grupoEquipoRepo.save(grupo);
	}

}
