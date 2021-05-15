package com.mindia.almacen.model;
// Generated 15-may-2021 11:58:12 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Registro generated by hbm2java
 */
@Entity
@Table(name = "registro", catalog = "almacen")
public class Registro implements java.io.Serializable {

	private Integer id;
	private Usuario usuario;
	private Date fecha;
	private Boolean entrada;
	private int entidadId;
	private String entidad;

	public Registro() {
	}

	public Registro(int entidadId, String entidad) {
		this.entidadId = entidadId;
		this.entidad = entidad;
	}

	public Registro(Usuario usuario, Date fecha, Boolean entrada, int entidadId, String entidad) {
		this.usuario = usuario;
		this.fecha = fecha;
		this.entrada = entrada;
		this.entidadId = entidadId;
		this.entidad = entidad;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "entrada")
	public Boolean getEntrada() {
		return this.entrada;
	}

	public void setEntrada(Boolean entrada) {
		this.entrada = entrada;
	}

	@Column(name = "entidad_id", nullable = false)
	public int getEntidadId() {
		return this.entidadId;
	}

	public void setEntidadId(int entidadId) {
		this.entidadId = entidadId;
	}

	@Column(name = "entidad", nullable = false, length = 20)
	public String getEntidad() {
		return this.entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

}
