package com.mindia.almacen.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindia.almacen.model.Llave;

@Repository
public interface LlaveRepository extends JpaRepository<Llave, Integer> {

	@Query("select l from Llave l where l.llaveId = ?1 and l.nombre = ?2")
	public List<Llave> obtenerByIdentificacion(int id, String nombre);

	@Query("select l from Llave l where l.nombre like %?1%")
	public List<Llave> obtenerLikeNombre(String nombre);

	@Query("select l from Llave l where l.estado = 'En uso'")
	public List<Llave> llavesEnUso();

}
