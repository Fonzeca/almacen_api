package com.mindia.almacen.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindia.almacen.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query("select u from Usuario u where u.nombreUsuario like %?1%")
	public List<Usuario> obtenerLikeNombreUsuario(String nombre);
}
