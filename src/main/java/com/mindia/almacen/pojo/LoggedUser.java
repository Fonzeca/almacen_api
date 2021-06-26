package com.mindia.almacen.pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class LoggedUser {
	
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("nombre")
	@Expose
	private String nombre;
	@SerializedName("apellido")
	@Expose
	private String apellido;
	@SerializedName("nombreUsuario")
	@Expose
	private String nombreUsuario;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("esAdmin")
	@Expose
	private Boolean esAdmin;
	@SerializedName("rol")
	@Expose
	private String rol;

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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(Boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}