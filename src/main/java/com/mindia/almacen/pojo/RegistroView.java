
package com.mindia.almacen.pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mindia.almacen.model.Registro;

@Generated("jsonschema2pojo")
public class RegistroView implements Comparable<RegistroView>{

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
    @SerializedName("entidad")
    @Expose
    private String entidad;
    
    @SerializedName("nombreEquipo")
    @Expose
    private String nombreEquipo;
    
    @SerializedName("nombreLlave")
    @Expose
    private String nombreLlave;
    
    @SerializedName("nombreGrupoEquipo")
    @Expose
    private String nombreGrupoEquipo;
    
    @SerializedName("nombreGrupoLlave")
    @Expose
    private String nombreGrupoLlave;
    
    public RegistroView() {
	}
    
    public RegistroView(Registro r) {
    	this.id = r.getId();
    	this.usuario = r.getUsuarioByUsuario().getNombreUsuario();
    	this.fecha = r.getFecha().toString();
    	this.entrada = r.getEntrada();
    	this.entidad = r.getEntidad();
    	
    	this.nombreEquipo = "";
    	this.nombreGrupoEquipo = "";
    	this.nombreGrupoLlave = "";
    	this.nombreLlave = "";
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

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getNombreLlave() {
		return nombreLlave;
	}

	public void setNombreLlave(String nombreLlave) {
		this.nombreLlave = nombreLlave;
	}

	public String getNombreGrupoEquipo() {
		return nombreGrupoEquipo;
	}

	public void setNombreGrupoEquipo(String nombreGrupoEquipo) {
		this.nombreGrupoEquipo = nombreGrupoEquipo;
	}

	public String getNombreGrupoLlave() {
		return nombreGrupoLlave;
	}

	public void setNombreGrupoLlave(String nombreGrupoLlave) {
		this.nombreGrupoLlave = nombreGrupoLlave;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	@Override
	public int compareTo(RegistroView o) {
		return -this.id.compareTo(o.id);
	}


}
