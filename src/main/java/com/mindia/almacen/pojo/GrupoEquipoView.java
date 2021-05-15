
package com.mindia.almacen.pojo;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mindia.almacen.model.GrupoEquipos;

@Generated("jsonschema2pojo")
public class GrupoEquipoView {

    @SerializedName("grupoId")
    @Expose
    private Integer grupoId;
    @SerializedName("estado")
	@Expose
	private String estado;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("equipos")
    @Expose
    private List<EquipoView> equipos = null;
    
    public GrupoEquipoView() {
	}
    
    public GrupoEquipoView(GrupoEquipos equipos) {
    	this.grupoId = equipos.getGrupoEquipoId();
    	this.nombre = equipos.getNombre();
    	
    	int contadorDisponible = equipos.getEquipos().stream().filter(o -> o.getEstado().equals("Disponible")).collect(Collectors.toList()).size();
    	int contadorUso = equipos.getEquipos().stream().filter(o -> o.getEstado().equals("En uso")).collect(Collectors.toList()).size();
    	int sizeEquipos = equipos.getEquipos().size();
    	
    	if(contadorDisponible == sizeEquipos) {
    		this.estado = "Disponible";
    	}else if(contadorUso == sizeEquipos){
    		this.estado = "En uso";
    	}else {
    		this.estado = "Parcial";
    	}
    	
    	this.equipos = equipos.getEquipos().stream().map(o -> new EquipoView(o)).collect(Collectors.toList());
	}


    public Integer getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

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

	public List<EquipoView> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<EquipoView> equipos) {
		this.equipos = equipos;
	}

}
