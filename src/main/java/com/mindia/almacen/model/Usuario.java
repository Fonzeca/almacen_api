package com.mindia.almacen.model;
// Generated 14-may-2021 19:31:48 by Hibernate Tools 5.2.12.Final

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
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "almacen", uniqueConstraints = @UniqueConstraint(columnNames = "NombreUsuario"))
public class Usuario implements java.io.Serializable {

	private Integer usuarioId;
	private Area area;
	private Rol rol;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private boolean activo;
	private Set<Equipo> equipos = new HashSet<Equipo>(0);
	private Set<Registro> registros = new HashSet<Registro>(0);
	private Set<Pedido> pedidos = new HashSet<Pedido>(0);
	private Set<Pedido> pedidos_1 = new HashSet<Pedido>(0);
	private Set<Area> areas = new HashSet<Area>(0);

	public Usuario() {
	}

	public Usuario(Area area, Rol rol, String nombreUsuario, String nombre, String apellido, String email,
			boolean activo) {
		this.area = area;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.activo = activo;
	}

	public Usuario(Area area, Rol rol, String nombreUsuario, String nombre, String apellido, String email,
			boolean activo, Set<Equipo> equipos, Set<Registro> registros, Set<Pedido> pedidos, Set<Pedido> pedidos_1,
			Set<Area> areas) {
		this.area = area;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.activo = activo;
		this.equipos = equipos;
		this.registros = registros;
		this.pedidos = pedidos;
		this.pedidos_1 = pedidos_1;
		this.areas = areas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "UsuarioID", unique = true, nullable = false)
	public Integer getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Area", nullable = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Rol", nullable = false)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Column(name = "NombreUsuario", unique = true, nullable = false, length = 30)
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Column(name = "nombre", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", nullable = false, length = 20)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "email", nullable = false, length = 40)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Pedido> getPedidos_1() {
		return this.pedidos_1;
	}

	public void setPedidos_1(Set<Pedido> pedidos_1) {
		this.pedidos_1 = pedidos_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}

}
