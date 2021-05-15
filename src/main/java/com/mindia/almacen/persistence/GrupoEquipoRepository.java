package com.mindia.almacen.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindia.almacen.model.GrupoEquipos;

public interface GrupoEquipoRepository extends JpaRepository<GrupoEquipos, Integer>{
	
	@Query("select g from GrupoEquipos g where g.grupoEquipoId = ?1 and g.nombre = ?2")
	GrupoEquipos obtenerByIdentificacion(int id, String nombre);
}
