
package com.mindia.almacen.pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mindia.almacen.model.Registro;

@Generated("jsonschema2pojo")
public class RegistroView {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("entrada")
    @Expose
    private Boolean entrada;
    
    public RegistroView() {
	}
    
    public RegistroView(Registro r) {
    	this.id = r.getRegistroId();
    	this.usuario = r.getUsuario().getNombreUsuario();
    	this.fecha = r.getFecha().toString();
    	this.entrada = r.getEntrada();
    	
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getEntrada() {
        return entrada;
    }

    public void setEntrada(Boolean entrada) {
        this.entrada = entrada;
    }

}
