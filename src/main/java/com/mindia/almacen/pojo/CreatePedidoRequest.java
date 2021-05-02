package com.mindia.almacen.pojo;


import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CreatePedidoRequest {
    @SerializedName("observaciones")
    @Expose
    private String observaciones;
    
    @SerializedName("nombreUsuario")
    @Expose
    private String nombreUsuario;
    
    @SerializedName("nombresArticulos")
    @Expose
    private String nombresArticulos;
    
    @SerializedName("cantidadesArticulos")
    @Expose
    private String cantidadesArticulos;

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombresArticulos() {
		return nombresArticulos;
	}

	public void setNombresArticulos(String nombresArticulos) {
		this.nombresArticulos = nombresArticulos;
	}

	public String getCantidadesArticulos() {
		return cantidadesArticulos;
	}

	public void setCantidadesArticulos(String cantidadesArticulos) {
		this.cantidadesArticulos = cantidadesArticulos;
	}
    
}
