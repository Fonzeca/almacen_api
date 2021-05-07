
package com.mindia.almacen.pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mindia.almacen.model.Equipo;

@Generated("jsonschema2pojo")
public class EquipoView {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("serial")
    @Expose
    private String serial;
    @SerializedName("modelo")
    @Expose
    private String modelo;
    @SerializedName("observaciones")
    @Expose
    private String observaciones;
    @SerializedName("accesorios")
    @Expose
    private String accesorios;
    @SerializedName("enUso")
    @Expose
    private boolean enUso;
    
    public EquipoView() {
	}
    
    public EquipoView(Equipo equipo) {
    	this.id = equipo.getEquipoId();
    	this.usuario = equipo.getUsuario().getNombreUsuario();
    	this.nombre = equipo.getNombre();
    	this.serial = equipo.getSerial();
    	this.modelo = equipo.getModelo();
    	this.observaciones = equipo.getObservaciones();
    	this.accesorios = equipo.getAccesorios();
    	this.enUso = equipo.getEstado().equals("En uso");
	}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

	public boolean isEnUso() {
		return enUso;
	}

	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
