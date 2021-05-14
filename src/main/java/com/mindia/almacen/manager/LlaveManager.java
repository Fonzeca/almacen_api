package com.mindia.almacen.manager;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mindia.almacen.model.GrupoLlaves;
import com.mindia.almacen.model.Llave;
import com.mindia.almacen.persistence.GrupoLlaveRepository;
import com.mindia.almacen.persistence.LlaveRepository;
import com.mindia.almacen.pojo.LlaveGrupoView;
import com.mindia.almacen.pojo.LlaveView;

@Service
public class LlaveManager {
	
	@Autowired
	GrupoLlaveRepository grupoLlaveRepo;
	
	@Autowired
	LlaveRepository llaveRepo;

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

	public void changeLlaveStatus(String id, String entrada) {
		//TODO: codigo repetido
		Llave llave = null;
		try {
			llave = llaveRepo.findById(Long.parseLong(id)).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Llave no encontrada");
		}
		
		llave.setEstado(entrada);
		
		llaveRepo.save(llave);
	}
	
	public LlaveGrupoView getGrupoLlaveByIdentificacion(String identificacion) {
		String[] ident = identificacion.split("-");
		String nombre = ident[0];
		String idStr = ident[1];
		Integer id = Integer.parseInt(idStr);
		
		var llave = grupoLlaveRepo.obtenerByIdentificacion(id, nombre);
		if(llave.size() != 1) {
			if(llave.size() > 1)
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Id duplicados");
			if(llave.size() < 1) 
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Llave no encontrada");
		}
		
		GrupoLlaves grLlave = llave.get(0);
		
		LlaveGrupoView view = new LlaveGrupoView(grLlave);
		
		return view;
	}
	
}
