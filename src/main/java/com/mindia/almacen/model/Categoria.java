package com.mindia.almacen.model;
// Generated 13/06/2021 16:52:59 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name = "categoria", catalog = "almacen")
public class Categoria implements java.io.Serializable {

	private Integer categoriaId;
	private String nombre;
	private Set<Subcategoria> subcategorias = new HashSet<Subcategoria>(0);

	public Categoria() {
	}

	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(String nombre, Set<Subcategoria> subcategorias) {
		this.nombre = nombre;
		this.subcategorias = subcategorias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "categoria_id", unique = true, nullable = false)
	public Integer getCategoriaId() {
		return this.categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Subcategoria> getSubcategorias() {
		return this.subcategorias;
	}

	public void setSubcategorias(Set<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

}
