package com.mindia.almacen.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mindia.almacen.manager.RegistroManager.TIPO_REGISTRO;
import com.mindia.almacen.model.Equipo;
import com.mindia.almacen.model.GrupoEquipos;
import com.mindia.almacen.model.GrupoLlaves;
import com.mindia.almacen.model.Llave;
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

	public void changeStatus(String id, String entrada, String username, String guardia, TIPO_REGISTRO tipo) {
		if (tipo == TIPO_REGISTRO.GRUPO_EQUIPO) {
			GrupoEquipos grupo = grupoEquipoRepo.getOne(Integer.parseInt(id));
			for (Equipo equipo : grupo.getEquipos()) {
				equipoManager.changeStatus(username, equipo.getEquipoId());
			}
			grupoEquipoRepo.save(grupo);
		} else if (tipo == TIPO_REGISTRO.GRUPO_LLAVE) {
			GrupoLlaves grupoLlaves = grupoLlaveRepo.getOne(Integer.parseInt(id));
			for (Llave llave : grupoLlaves.getLlaves()) {
				llaveManager.changeLlaveStatus(llave.getLlaveId().toString(), entrada, username, guardia);
			}
			grupoLlaveRepo.save(grupoLlaves);
		}
		Usuario encargado = UsuarioDB.getUsuarioByNombreUsuario(guardia);
		int idEntidad = Integer.parseInt(id);
		int user = UsuarioDB.getUsuarioByNombreUsuario(username).getId();
		if (entrada.equals("En uso")) {
			registroManager.createRegistro(false, user, tipo, idEntidad, encargado);
		} else {
			registroManager.createRegistro(true, user, tipo, idEntidad, encargado);
		}
	}

}
