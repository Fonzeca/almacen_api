
package com.mindia.almacen.pojo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class PedidoDetalleView {

    @SerializedName("pedidoId")
    @Expose
    private Integer pedidoId;
    @SerializedName("estadopedido")
    @Expose
    private String estadopedido;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("observaciones")
    @Expose
    private String observaciones;
    @SerializedName("pedidos")
    @Expose
    private List<ArticuloPedidoView> pedidos = null;

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getEstadopedido() {
        return estadopedido;
    }

    public void setEstadopedido(String estadopedido) {
        this.estadopedido = estadopedido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<ArticuloPedidoView> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ArticuloPedidoView> pedidos) {
        this.pedidos = pedidos;
    }

}
