package com.mindia.almacen.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mindia.almacen.model.Llave;

public class LlaveView {
	
	@SerializedName("llaveId")
	@Expose
	private Integer llaveId;
	@SerializedName("nombre")
	@Expose
	private String nombre;
	@SerializedName("copia")
	@Expose
	private String copia;
	@SerializedName("grupo")
	@Expose
	private String grupo;
	@SerializedName("estado")
	@Expose
	private String estado;
	@SerializedName("observaciones")
	@Expose
	private String observaciones;
	@SerializedName("ubicacion")
	@Expose
	private String ubicacion;

	public LlaveView(Llave llave) {
		this.copia = llave.getCopia();
		this.estado = llave.getEstado();
		this.grupo = llave.getGrupoLlaves() == null ? null : llave.getGrupoLlaves().getNombre();
		this.nombre = llave.getNombre();
		this.observaciones = llave.getObservaciones();
		this.ubicacion = llave.getLugar() == null ? null : llave.getLugar().getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCopia() {
		return copia;
	}

	public void setCopia(String copia) {
		this.copia = copia;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getLlaveId() {
		return llaveId;
	}

	public void setLlaveId(Integer llaveId) {
		this.llaveId = llaveId;
	}

}
