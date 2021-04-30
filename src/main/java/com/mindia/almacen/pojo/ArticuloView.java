package com.mindia.almacen.pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ArticuloView {

	@SerializedName("nombre")
	@Expose
	private String nombre;
	@SerializedName("estado")
	@Expose
	private String estado;
	@SerializedName("subcategoria")
	@Expose
	private String subcategoria;
	@SerializedName("stock")
	@Expose
	private Integer stock;
	@SerializedName("qr")
	@Expose
	private String qr;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getQr() {
		return qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}

}