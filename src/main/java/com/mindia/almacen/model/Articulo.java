package com.mindia.almacen.model;
// Generated 15-may-2021 11:58:12 by Hibernate Tools 5.2.12.Final

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
 * Articulo generated by hbm2java
 */
@Entity
@Table(name = "articulo", catalog = "almacen")
public class Articulo implements java.io.Serializable {

	private Integer articuloId;
	private Estadoarticulo estadoarticulo;
	private Proveedor proveedor;
	private Subcategoria subcategoria;
	private String nombre;
	private double costo;
	private Date fechaAgregado;
	private int stockMinimo;
	private int stock;
	private String codigoQr;
	private Set<Pedidoxarticulos> pedidoxarticuloses = new HashSet<Pedidoxarticulos>(0);
	private Set<Pedidoxarticulos> pedidoxarticuloses_1 = new HashSet<Pedidoxarticulos>(0);

	public Articulo() {
	}

	public Articulo(Estadoarticulo estadoarticulo, Proveedor proveedor, Subcategoria subcategoria, String nombre,
			double costo, Date fechaAgregado, int stockMinimo, int stock) {
		this.estadoarticulo = estadoarticulo;
		this.proveedor = proveedor;
		this.subcategoria = subcategoria;
		this.nombre = nombre;
		this.costo = costo;
		this.fechaAgregado = fechaAgregado;
		this.stockMinimo = stockMinimo;
		this.stock = stock;
	}

	public Articulo(Estadoarticulo estadoarticulo, Proveedor proveedor, Subcategoria subcategoria, String nombre,
			double costo, Date fechaAgregado, int stockMinimo, int stock, String codigoQr,
			Set<Pedidoxarticulos> pedidoxarticuloses, Set<Pedidoxarticulos> pedidoxarticuloses_1) {
		this.estadoarticulo = estadoarticulo;
		this.proveedor = proveedor;
		this.subcategoria = subcategoria;
		this.nombre = nombre;
		this.costo = costo;
		this.fechaAgregado = fechaAgregado;
		this.stockMinimo = stockMinimo;
		this.stock = stock;
		this.codigoQr = codigoQr;
		this.pedidoxarticuloses = pedidoxarticuloses;
		this.pedidoxarticuloses_1 = pedidoxarticuloses_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "articulo_id", unique = true, nullable = false)
	public Integer getArticuloId() {
		return this.articuloId;
	}

	public void setArticuloId(Integer articuloId) {
		this.articuloId = articuloId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado", nullable = false)
	public Estadoarticulo getEstadoarticulo() {
		return this.estadoarticulo;
	}

	public void setEstadoarticulo(Estadoarticulo estadoarticulo) {
		this.estadoarticulo = estadoarticulo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proveedor", nullable = false)
	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria", nullable = false)
	public Subcategoria getSubcategoria() {
		return this.subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "costo", nullable = false, precision = 22, scale = 0)
	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_agregado", nullable = false, length = 10)
	public Date getFechaAgregado() {
		return this.fechaAgregado;
	}

	public void setFechaAgregado(Date fechaAgregado) {
		this.fechaAgregado = fechaAgregado;
	}

	@Column(name = "stock_minimo", nullable = false)
	public int getStockMinimo() {
		return this.stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	@Column(name = "stock", nullable = false)
	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column(name = "codigo_qr", length = 100)
	public String getCodigoQr() {
		return this.codigoQr;
	}

	public void setCodigoQr(String codigoQr) {
		this.codigoQr = codigoQr;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articulo")
	public Set<Pedidoxarticulos> getPedidoxarticuloses() {
		return this.pedidoxarticuloses;
	}

	public void setPedidoxarticuloses(Set<Pedidoxarticulos> pedidoxarticuloses) {
		this.pedidoxarticuloses = pedidoxarticuloses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articulo")
	public Set<Pedidoxarticulos> getPedidoxarticuloses_1() {
		return this.pedidoxarticuloses_1;
	}

	public void setPedidoxarticuloses_1(Set<Pedidoxarticulos> pedidoxarticuloses_1) {
		this.pedidoxarticuloses_1 = pedidoxarticuloses_1;
	}

}
