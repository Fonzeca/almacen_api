package com.mindia.almacen.pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class UsuarioView {

	@SerializedName("nombreUsuario")
	@Expose
	private String nombreUsuario;
	@SerializedName("nombre")
	@Expose
	private String nombre;
	@SerializedName("apellido")
	@Expose
	private String apellido;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}