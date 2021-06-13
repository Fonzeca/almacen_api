package com.mindia.almacen.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindia.almacen.model.Registro;
import com.mindia.almacen.model.Usuario;
import com.mindia.almacen.persistence.EquipoDB;
import com.mindia.almacen.persistence.LlaveRepository;
import com.mindia.almacen.persistence.RegistroDB;
import com.mindia.almacen.persistence.UsuarioDB;
import com.mindia.almacen.pojo.RegistroView;


@Service
public class RegistroManager {
	
	@Autowired
	LlaveRepository llaveRepository;
	
	@Autowired
	GrupoManager grupoManager;
	
	public static enum TIPO_REGISTRO {
		EQUIPO("Equipo"), 
		LLAVE("Llave"), 
		GRUPO_EQUIPO("Grupo equipo"), 
		GRUPO_LLAVE("Grupo llave");
	
		public final String label;

	    private TIPO_REGISTRO(String label) {
	        this.label = label;
	    }
	    
	    public static TIPO_REGISTRO getByValue(String value) {
            for (TIPO_REGISTRO tradeStatus : values()) {
                if (tradeStatus.label.equals(value)) {
                    return tradeStatus;
                }
            }
            return null;
        }
	}
	
	public void createRegistro(boolean entrada, int user, TIPO_REGISTRO tipo, int idEntidad) {
		System.out.println("Creando registro");
		
		//Creamos el registro
		Registro registro = new Registro();
		registro.setFecha(new Date());
		registro.setEntrada(entrada);
		
		//Traemos el user 
		Usuario usuario = UsuarioDB.getUsuarioByID(user);
		registro.setUsuarioByUsuario(usuario);
		
		Object entidad = null;
		
		//Buscamos el tipo de entidad y la entidad
		switch(tipo) {
			case EQUIPO:
				entidad = EquipoDB.getEquipoByID(idEntidad);
				break;
			case LLAVE:
				entidad = llaveRepository.getOne(idEntidad);
				break;
			case GRUPO_EQUIPO:
				entidad = grupoManager.getGrupoEquipoById(idEntidad);
				break;
			case GRUPO_LLAVE:
				entidad = grupoManager.getGrupoLlaveById(idEntidad);
				break;
		}
		
		if(entidad == null) {
			System.err.println("Entidad no encontrada");
			return;
		}
		
		registro.setEntidadId(idEntidad);
		registro.setEntidad(tipo.label);
		
		RegistroDB.crearRegistro(registro);
	}
	
	public static List<Registro> getLastRegistrosByEntidadAndId(TIPO_REGISTRO tipo, List<Integer> ids){
		List<Registro> registros = new ArrayList<Registro>();
		
		for (Integer id : ids) {
			registros.add(RegistroDB.getLastRegistroByIdAndTipo(tipo, id));
		}
		
		return registros;
	}
	
	public List<RegistroView> getAllRegistros() {
		List<RegistroView> registrosView = new ArrayList<RegistroView>();
		
		
		List<Registro> registros = RegistroDB.getRegistros();
		
		for (Registro registro : registros) {
			RegistroView viewSingle = new RegistroView(registro);
			
			int id = registro.getEntidadId();
			
			switch(TIPO_REGISTRO.getByValue(registro.getEntidad())) {
				case EQUIPO:
					viewSingle.setNombreEquipo(EquipoDB.getEquipoByID(id).getNombre());
					break;
				case LLAVE:
					viewSingle.setNombreLlave(llaveRepository.getOne(id).getNombre());
					break;
				case GRUPO_EQUIPO:
					viewSingle.setNombreGrupoEquipo(grupoManager.getGrupoEquipoById(id).getNombre());
					break;
				case GRUPO_LLAVE:
					viewSingle.setNombreGrupoLlave(grupoManager.getGrupoLlaveById(id).getNombre());
					break;
			}
			
			registrosView.add(viewSingle);
		}
		
		Collections.sort(registrosView);
		
		return registrosView;
	}
}
