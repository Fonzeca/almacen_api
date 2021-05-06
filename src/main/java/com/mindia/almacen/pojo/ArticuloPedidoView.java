
package com.mindia.almacen.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ArticuloPedidoView {

    @SerializedName("cantidad")
    @Expose
    private Integer cantidad;
    @SerializedName("articuloId")
    @Expose
    private Integer articuloId;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Integer articuloId) {
        this.articuloId = articuloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
