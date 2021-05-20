package com.mindia.almacen.pojo;

import java.util.List;

public class ActualizarStockAxP {

	private boolean salida;
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
