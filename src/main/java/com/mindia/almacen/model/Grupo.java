package com.mindia.almacen.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupoLlaves", catalog = "almacen")
public class Grupo implements java.io.Serializable {

	private Integer grupoId;
	private String nombre;

	public Grupo() {
	}

	public Grupo(String nombre) {
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "grupoId", unique = true, nullable = false)
	public Integer getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}

	@Column(name = "nombre", length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
