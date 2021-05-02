
package com.mindia.almacen.pojo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CategoriaView {

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("subcategorias")
    @Expose
    private List<SubcategoriaView> subcategorias = null;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SubcategoriaView> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<SubcategoriaView> subcategorias) {
        this.subcategorias = subcategorias;
    }

}
