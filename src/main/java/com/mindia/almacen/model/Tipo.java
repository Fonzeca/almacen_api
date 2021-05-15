package com.mindia.almacen.model;
// Generated 14-may-2021 19:31:48 by Hibernate Tools 5.2.12.Final

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
 * Tipo generated by hbm2java
 */
@Entity
@Table(name = "tipo", catalog = "almacen")
public class Tipo implements java.io.Serializable {

	private Integer tipoId;
	private String nombre;
	private Set<Equipo> equipos = new HashSet<Equipo>(0);

	public Tipo() {
	}

	public Tipo(String nombre, Set<Equipo> equipos) {
		this.nombre = nombre;
		this.equipos = equipos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "tipoId", unique = true, nullable = false)
	public Integer getTipoId() {
		return this.tipoId;
	}

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	@Column(name = "nombre", length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo")
	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

}
