package com.mindia.almacen.model;
// Generated 14-may-2021 10:25:50 by Hibernate Tools 5.2.12.Final

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

/**
 * Proveedor generated by hbm2java
 */
@Entity
@Table(name = "proveedor", catalog = "almacen")
public class Proveedor implements java.io.Serializable {

	private Integer provId;
	private String provNombre;
	private String provTel;
	private String provContacto;
	private String provDireccion;
	private String provMail;
	private Set<Articulo> articulos = new HashSet<Articulo>(0);
	private Set<Articulo> articulos_1 = new HashSet<Articulo>(0);

	public Proveedor() {
	}

	public Proveedor(String provNombre, String provTel, String provContacto, String provDireccion, String provMail) {
		this.provNombre = provNombre;
		this.provTel = provTel;
		this.provContacto = provContacto;
		this.provDireccion = provDireccion;
		this.provMail = provMail;
	}

	public Proveedor(String provNombre, String provTel, String provContacto, String provDireccion, String provMail,
			Set<Articulo> articulos, Set<Articulo> articulos_1) {
		this.provNombre = provNombre;
		this.provTel = provTel;
		this.provContacto = provContacto;
		this.provDireccion = provDireccion;
		this.provMail = provMail;
		this.articulos = articulos;
		this.articulos_1 = articulos_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ProvID", unique = true, nullable = false)
	public Integer getProvId() {
		return this.provId;
	}

	public void setProvId(Integer provId) {
		this.provId = provId;
	}

	@Column(name = "ProvNombre", nullable = false, length = 30)
	public String getProvNombre() {
		return this.provNombre;
	}

	public void setProvNombre(String provNombre) {
		this.provNombre = provNombre;
	}

	@Column(name = "ProvTel", nullable = false, length = 30)
	public String getProvTel() {
		return this.provTel;
	}

	public void setProvTel(String provTel) {
		this.provTel = provTel;
	}

	@Column(name = "ProvContacto", nullable = false, length = 20)
	public String getProvContacto() {
		return this.provContacto;
	}

	public void setProvContacto(String provContacto) {
		this.provContacto = provContacto;
	}

	@Column(name = "ProvDireccion", nullable = false, length = 50)
	public String getProvDireccion() {
		return this.provDireccion;
	}

	public void setProvDireccion(String provDireccion) {
		this.provDireccion = provDireccion;
	}

	@Column(name = "ProvMail", nullable = false, length = 30)
	public String getProvMail() {
		return this.provMail;
	}

	public void setProvMail(String provMail) {
		this.provMail = provMail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	public Set<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	public Set<Articulo> getArticulos_1() {
		return this.articulos_1;
	}

	public void setArticulos_1(Set<Articulo> articulos_1) {
		this.articulos_1 = articulos_1;
	}

}
