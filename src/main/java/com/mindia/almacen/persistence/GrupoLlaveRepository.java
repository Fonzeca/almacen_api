package com.mindia.almacen.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindia.almacen.model.GrupoLlaves;


@Repository
public interface GrupoLlaveRepository extends JpaRepository<GrupoLlaves, Integer>  {
	
	List<GrupoLlaves> findByNombre(String nombre);
	
	@Query("select g from GrupoLlaves g where g.grupoId = ?1 and g.nombre = ?2")
	List<GrupoLlaves> obtenerByIdentificacion(int id, String nombre);
	
}
