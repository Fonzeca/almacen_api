package com.mindia.almacen.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mindia.almacen.model.GrupoEquipos;
import com.mindia.almacen.model.GrupoLlaves;
import com.mindia.almacen.persistence.GrupoEquipoRepository;
import com.mindia.almacen.persistence.GrupoLlaveRepository;
import com.mindia.almacen.pojo.GrupoEquipoView;
import com.mindia.almacen.pojo.GrupoLlaveView;
import com.mindia.almacen.utils.QrId;

@Service
public class GrupoManager {
	
	@Autowired
	GrupoLlaveRepository grupoLlaveRepo;
	
	@Autowired
	GrupoEquipoRepository grupoEquipoRepo;

	public GrupoLlaveView getGrupoLlaveByQr(String identificacion) {
		QrId qrId = new QrId(identificacion);
		
		GrupoLlaves grupoLlave = grupoLlaveRepo.obtenerByIdentificacion(qrId.id, qrId.value);
		
		if(grupoLlave == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de llaves no encontrada");
		}
		
		return new GrupoLlaveView(grupoLlave);
	}
	
	public GrupoEquipoView getGrupoEquipoByQr(String identificacion) {
		QrId qrId = new QrId(identificacion);
		
		GrupoEquipos grupoEquipo = grupoEquipoRepo.obtenerByIdentificacion(qrId.id, qrId.value);
		
		if(grupoEquipo == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de equipos no encontrada");
		}
		
		return new GrupoEquipoView(grupoEquipo);
	}
	

}
