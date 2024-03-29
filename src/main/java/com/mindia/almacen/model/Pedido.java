package com.mindia.almacen.model;
// Generated 26/07/2021 14:34:34 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pedido generated by hbm2java
 */
@Entity
@Table(name = "pedido", catalog = "almacen")
public class Pedido implements java.io.Serializable {

	private Integer pedidoId;
	private Estadopedido estadopedido;
	private Usuario usuario;
	private Date fecha;
	private String observaciones;
	private Set<Pedidoxarticulos> pedidoxarticuloses = new HashSet<Pedidoxarticulos>(0);

	public Pedido() {
	}

	public Pedido(Estadopedido estadopedido, Usuario usuario, Date fecha) {
		this.estadopedido = estadopedido;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public Pedido(Estadopedido estadopedido, Usuario usuario, Date fecha, String observaciones,
			Set<Pedidoxarticulos> pedidoxarticuloses) {
		this.estadopedido = estadopedido;
		this.usuario = usuario;
		this.fecha = fecha;
		this.observaciones = observaciones;
		this.pedidoxarticuloses = pedidoxarticuloses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "pedido_id", unique = true, nullable = false)
	public Integer getPedidoId() {
		return this.pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado", nullable = false)
	public Estadopedido getEstadopedido() {
		return this.estadopedido;
	}

	public void setEstadopedido(Estadopedido estadopedido) {
		this.estadopedido = estadopedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, length = 19)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "observaciones", length = 200)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	public Set<Pedidoxarticulos> getPedidoxarticuloses() {
		return this.pedidoxarticuloses;
	}

	public void setPedidoxarticuloses(Set<Pedidoxarticulos> pedidoxarticuloses) {
		this.pedidoxarticuloses = pedidoxarticuloses;
	}

}
