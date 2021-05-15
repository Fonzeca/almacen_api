package com.mindia.almacen.model;
// Generated 15-may-2021 11:58:12 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Estadopedido generated by hbm2java
 */
@Entity
@Table(name = "estadopedido", catalog = "almacen", uniqueConstraints = @UniqueConstraint(columnNames = "nombre_estado"))
public class Estadopedido implements java.io.Serializable {

	private Integer estadoPedidoId;
	private String nombreEstado;
	private Set<Pedido> pedidos = new HashSet<Pedido>(0);

	public Estadopedido() {
	}

	public Estadopedido(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public Estadopedido(String nombreEstado, Set<Pedido> pedidos) {
		this.nombreEstado = nombreEstado;
		this.pedidos = pedidos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "estado_pedido_id", unique = true, nullable = false)
	public Integer getEstadoPedidoId() {
		return this.estadoPedidoId;
	}

	public void setEstadoPedidoId(Integer estadoPedidoId) {
		this.estadoPedidoId = estadoPedidoId;
	}

	@Column(name = "nombre_estado", unique = true, nullable = false, length = 20)
	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadopedido")
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
