package com.mindia.almacen.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mindia.almacen.manager.RegistroManager.TIPO_REGISTRO;
import com.mindia.almacen.model.Llave;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.GrupoLlaveRepository;
import com.mindia.almacen.persistence.LlaveRepository;
import com.mindia.almacen.persistence.UsuarioDB;
import com.mindia.almacen.pojo.LlaveView;

@Service
public class LlaveManager {

	@Autowired
	GrupoLlaveRepository grupoLlaveRepo;

	@Autowired
	LlaveRepository llaveRepo;

	@Autowired
	RegistroManager registroManager;

	public void crearLlave(Llave llave) {
		llaveRepo.save(llave);
	}

	public LlaveView getLlaveByIdentificacion(String id) {
		Llave llave = null;
		try {
			llave = llaveRepo.findById(Integer.parseInt(id)).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Llave no encontrada");
		}

		LlaveView llaveView = new LlaveView(llave);
		return llaveView;
	}

	public void changeLlaveStatus(String id, String entrada, String userName) {
		// TODO: codigo repetido
		Llave llave = null;
		try {
			llave = llaveRepo.findById(Integer.parseInt(id)).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Llave no encontrada");
		}

		llave.setEstado(entrada);

		llaveRepo.save(llave);

		Usuario user = UsuarioDB.getUsuarioByNombreUsuario(userName);

		if (entrada.equals("En uso")) {
			registroManager.createRegistro(false, user.getId(), TIPO_REGISTRO.LLAVE, llave.getLlaveId());
		} else {
			registroManager.createRegistro(true, user.getId(), TIPO_REGISTRO.LLAVE, llave.getLlaveId());
		}
	}

	public List<LlaveView> getLlavesEnUso() {
		List<LlaveView> llaves = new ArrayList<LlaveView>();
		for (Llave llave : llaveRepo.llavesEnUso()) {
			LlaveView llaveView = new LlaveView(llave);
			llaves.add(llaveView);
		}
		return llaves;
	}
}
