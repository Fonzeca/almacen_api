package com.mindia.almacen.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActualizarStockAxP {

	private boolean salida;
	@SerializedName("nombre")
	@Expose
	private List<String> nombreArticuloFaltante;

	public boolean isSalida() {
		return salida;
	}

	public void setSalida(boolean salida) {
		this.salida = salida;
	}

	public List<String> getNombreArticuloFaltante() {
		return nombreArticuloFaltante;
	}

	public void setNombreArticuloFaltante(List<String> nombreArticuloFaltante) {
		this.nombreArticuloFaltante = nombreArticuloFaltante;
	}

}
