
package com.mindia.almacen.pojo;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mindia.almacen.model.GrupoLlaves;

@Generated("jsonschema2pojo")
public class GrupoLlaveView {

    @SerializedName("grupoId")
    @Expose
    private Integer grupoId;
    @SerializedName("estado")
	@Expose
	private String estado;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("llaves")
    @Expose
    private List<LlaveView> llaves = null;
    
    public GrupoLlaveView() {
	}
    
    public GrupoLlaveView(GrupoLlaves llaves) {
    	this.grupoId = llaves.getGrupoId();
    	this.nombre = llaves.getNombre();
    	
    	int contadorDisponible = llaves.getLlaves().stream().filter(o -> o.getEstado().equals("Disponible")).collect(Collectors.toList()).size();
    	int contadorUso = llaves.getLlaves().stream().filter(o -> o.getEstado().equals("En uso")).collect(Collectors.toList()).size();
    	int sizeLlaves = llaves.getLlaves().size();
    	
    	if(contadorDisponible == sizeLlaves) {
    		this.estado = "Disponible";
    	}else if(contadorUso == sizeLlaves){
    		this.estado = "En uso";
    	}else {
    		this.estado = "Parcial";
    	}
    	
    	this.llaves = llaves.getLlaves().stream().map(o -> new LlaveView(o)).collect(Collectors.toList());
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

    public List<LlaveView> getLlaves() {
        return llaves;
    }

    public void setLlaves(List<LlaveView> llaves) {
        this.llaves = llaves;
    }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
