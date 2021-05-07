
package com.mindia.almacen.pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mindia.almacen.model.Equipo;

@Generated("jsonschema2pojo")
public class EquipoView {

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
    @SerializedName("estado")
    @Expose
    private String estado;
    
    public EquipoView() {
	}
    
    public EquipoView(Equipo equipo) {
    	this.usuario = equipo.getUsuario().getNombreUsuario();
    	this.nombre = equipo.getNombre();
    	this.serial = equipo.getSerial();
    	this.modelo = equipo.getModelo();
    	this.observaciones = equipo.getObservaciones();
    	this.accesorios = equipo.getAccesorios();
    	this.estado = equipo.getEstado();
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
