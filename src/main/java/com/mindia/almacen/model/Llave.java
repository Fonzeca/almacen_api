package com.mindia.almacen.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.mindia.almacen.manager.GrupoManager;
import com.mindia.almacen.manager.LugarManager;

@Entity
@Table(name = "llave", catalog = "almacen")
public class Llave implements java.io.Serializable {

	@Expose(serialize = true, deserialize = true)
	private Integer llaveId;

	@Expose(serialize = true, deserialize = true)
	private String copia;

	@Expose(serialize = true, deserialize = true)
	private String nombre;

	@Expose(serialize = true, deserialize = true)
	private String observaciones;

	@Expose(serialize = true, deserialize = true)
	private String estado;

	@Expose(serialize = true, deserialize = true)
	private Lugar ubicacion;

	@Expose(serialize = true, deserialize = true)
	private Grupo grupo;

	public Llave() {
	}

	public Llave(String nombre, String estado, String copia, String observaciones, String ubicacion, String grupo) {
		this.copia = copia;
		this.estado = estado;
		this.grupo = GrupoManager.getGrupoByNombre(grupo);
		this.nombre = nombre;
		this.observaciones = observaciones;
		this.ubicacion = LugarManager.getLugarByNombre(ubicacion);
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "llaveId", unique = true, nullable = false)
	public Integer getLlaveId() {
		return llaveId;
	}

	public void setLlaveId(Integer llaveId) {
		this.llaveId = llaveId;
	}

	@Column(name = "copia", nullable = false, length = 3)
	public String getCopia() {
		return copia;
	}

	public void setCopia(String copia) {
		this.copia = copia;
	}

	@Column(name = "nombre", nullable = false, length = 20)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "observaciones", nullable = true, length = 140)
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "estado", nullable = false, length = 20)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ubicacion", nullable = false)
	public Lugar getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Lugar ubicacion) {
		this.ubicacion = ubicacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grupoId", nullable = false)
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
}
