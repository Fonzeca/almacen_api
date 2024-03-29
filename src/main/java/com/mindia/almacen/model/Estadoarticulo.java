package com.mindia.almacen.model;
// Generated 26/07/2021 14:34:34 by Hibernate Tools 5.2.12.Final

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
import javax.persistence.UniqueConstraint;

/**
 * Estadoarticulo generated by hbm2java
 */
@Entity
@Table(name = "estadoarticulo", catalog = "almacen", uniqueConstraints = @UniqueConstraint(columnNames = "nombre_estado"))
public class Estadoarticulo implements java.io.Serializable {

	private Integer estadoArticuloId;
	private String nombreEstado;
	private Set<Articulo> articulos = new HashSet<Articulo>(0);

	public Estadoarticulo() {
	}

	public Estadoarticulo(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public Estadoarticulo(String nombreEstado, Set<Articulo> articulos) {
		this.nombreEstado = nombreEstado;
		this.articulos = articulos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "estado_articulo_id", unique = true, nullable = false)
	public Integer getEstadoArticuloId() {
		return this.estadoArticuloId;
	}

	public void setEstadoArticuloId(Integer estadoArticuloId) {
		this.estadoArticuloId = estadoArticuloId;
	}

	@Column(name = "nombre_estado", unique = true, nullable = false, length = 20)
	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadoarticulo")
	public Set<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

}
