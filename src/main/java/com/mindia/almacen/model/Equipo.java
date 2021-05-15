package com.mindia.almacen.model;
// Generated 15-may-2021 19:58:24 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Equipo generated by hbm2java
 */
@Entity
@Table(name = "equipo", catalog = "almacen")
public class Equipo implements java.io.Serializable {

	private Integer equipoId;
	private GrupoEquipos grupoEquipos;
	private Lugar lugar;
	private Tipo tipo;
	private Usuario usuario;
	private String nombre;
	private String serial;
	private String modelo;
	private String observaciones;
	private String accesorios;
	private String estado;

	public Equipo() {
	}

	public Equipo(String estado) {
		this.estado = estado;
	}

	public Equipo(GrupoEquipos grupoEquipos, Lugar lugar, Tipo tipo, Usuario usuario, String nombre, String serial,
			String modelo, String observaciones, String accesorios, String estado) {
		this.grupoEquipos = grupoEquipos;
		this.lugar = lugar;
		this.tipo = tipo;
		this.usuario = usuario;
		this.nombre = nombre;
		this.serial = serial;
		this.modelo = modelo;
		this.observaciones = observaciones;
		this.accesorios = accesorios;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "equipo_id", unique = true, nullable = false)
	public Integer getEquipoId() {
		return this.equipoId;
	}

	public void setEquipoId(Integer equipoId) {
		this.equipoId = equipoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grupo_equipo_id")
	public GrupoEquipos getGrupoEquipos() {
		return this.grupoEquipos;
	}

	public void setGrupoEquipos(GrupoEquipos grupoEquipos) {
		this.grupoEquipos = grupoEquipos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lugar_habitual")
	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo")
	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_habitual")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nombre", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "serial", length = 50)
	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@Column(name = "modelo", length = 50)
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "observaciones", length = 140)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "accesorios", length = 140)
	public String getAccesorios() {
		return this.accesorios;
	}

	public void setAccesorios(String accesorios) {
		this.accesorios = accesorios;
	}

	@Column(name = "estado", nullable = false, length = 20)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
