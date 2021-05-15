package com.mindia.almacen.persistence;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mindia.almacen.model.Articulo;

public class ArticuloDB {

	public static Articulo getArticuloByID(int id) {
		Session sess = null;
		Articulo articulo;
		try {

			sess = HibernateUtils.openSession();
			articulo = sess.get(Articulo.class, id);
			Hibernate.initialize(articulo.getSubcategoria());
			Hibernate.initialize(articulo.getSubcategoria().getCategoria());
			Hibernate.initialize(articulo.getProveedor());
			Hibernate.initialize(articulo.getEstadoarticulo());

			return articulo;

		} finally {

			sess.close();
		}
	}

	public static List<Articulo> getListadoArticulos() {
		Session sess = null;
		List<Articulo> articulos = null;
		try {
			sess = HibernateUtils.openSession();
			Query<Articulo> query = sess.createQuery("select a from Articulo a where a.id!=null", Articulo.class);
			articulos = query.getResultList();
			for (Articulo ar : articulos) {
				Hibernate.initialize(ar.getSubcategoria());
				Hibernate.initialize(ar.getSubcategoria().getCategoria());
				Hibernate.initialize(ar.getEstadoarticulo());
				Hibernate.initialize(ar.getProveedor());
			}
			return articulos;
		} finally {
			sess.close();
		}
	}

	public static Articulo getArticuloByNombre(String nombre) {
		Session sess = null;
		Articulo articulo;
		try {

			sess = HibernateUtils.openSession();
			Query<Articulo> query = sess
					.createQuery("SELECT distinct a FROM Articulo a WHERE a.nombre='" + nombre + "'", Articulo.class);
			articulo = query.getResultList().get(0);
			Hibernate.initialize(articulo);
			Hibernate.initialize(articulo.getProveedor());
			Hibernate.initialize(articulo.getSubcategoria());
			Hibernate.initialize(articulo.getSubcategoria().getCategoria());
			Hibernate.initialize(articulo.getEstadoarticulo());

			return articulo;

		} finally {

			sess.close();
		}
	}

	public static List<Articulo> getArticulosLikeNombre(String nombre) {
		Session sess = null;
		List<Articulo> articulos = null;
		try {
			sess = HibernateUtils.openSession();
			Query<Articulo> query = sess.createQuery(
					"select a from Articulo a where a.id != null and a.nombre LIKE '%" + nombre + "%'", Articulo.class);
			query.setMaxResults(10);
			articulos = query.getResultList();
			for (Articulo ar : articulos) {
				Hibernate.initialize(ar.getSubcategoria());
				Hibernate.initialize(ar.getSubcategoria().getCategoria());
				Hibernate.initialize(ar.getEstadoarticulo());
				Hibernate.initialize(ar.getProveedor());
			}
			return articulos;
		} finally {
			sess.close();
		}
	}

	public static List<Articulo> getArticulosEnStock() {
		Session sess = null;
		List<Articulo> articulos = null;
		try {
			sess = HibernateUtils.openSession();
			Query<Articulo> query = sess.createQuery("select a from Articulo a where a.estado=1", Articulo.class);
			articulos = query.getResultList();
			for (Articulo a : articulos) {
				Hibernate.initialize(a.getEstadoarticulo());
				Hibernate.initialize(a.getPedidoxarticuloses());
				Hibernate.initialize(a.getProveedor());
				Hibernate.initialize(a.getSubcategoria());
			}
			return articulos;
		} finally {
			sess.close();
		}
	}

	public static List<Articulo> getArticulosByProveedor(int prov) {
		Session sess = null;
		List<Articulo> articulos = null;

		try {
			sess = HibernateUtils.openSession();
			Query<Articulo> query = sess.createQuery("select a from Articulo a where a.proveedor='" + prov + "'",
					Articulo.class);
			articulos = query.getResultList();
			for (Articulo a : articulos) {
				Hibernate.initialize(a.getSubcategoria());
				Hibernate.initialize(a.getSubcategoria().getCategoria());

				Hibernate.initialize(a.getEstadoarticulo());
			}

			return articulos;
		} finally {
			sess.close();
		}
	}

	public static void agregarArticuloNuevo(Articulo ar) {
		Session sess = null;
		Transaction tran = null;
		try {
			sess = HibernateUtils.openSession();
			tran = sess.beginTransaction();
			sess.save(ar);
			tran.commit();

		} finally {
			sess.close();
		}
	}

	public static void editarArticuloStock(String id, String cantidad) {
		Session sess = null;
		Articulo a = null;
		try {
			sess = HibernateUtils.openSession();
			Transaction tran = sess.beginTransaction();
			int idI = Integer.parseInt(id);
			a = sess.get(Articulo.class, idI);
			sess.saveOrUpdate(a);
			int cantidadI = Integer.valueOf(cantidad);
			a.setStock(a.getStock() + cantidadI);
			tran.commit();
		} finally {
			sess.close();
		}
	}

	public static void editarArticuloQr(String nombre, String qr) {
		Session sess = null;
		Articulo a = null;

		try {
			sess = HibernateUtils.openSession();
			Transaction tran = sess.beginTransaction();

			int id = getArticuloByNombre(nombre).getArticuloId();
			a = sess.get(Articulo.class, id);

			sess.saveOrUpdate(a);

			a.setCodigoQr(qr);

			tran.commit();
		} finally {

			sess.close();
		}
	}

	public static void editarArticulo(int id, String subc, String proveedor, String nombre, int stockMinimo,
			int stockMaximo, Double costo) {
		Session sess = null;
		Articulo a = null;

		try {
			sess = HibernateUtils.openSession();
			Transaction tran = sess.beginTransaction();

			a = getArticuloByID(id);
			sess.saveOrUpdate(a);
			a.setCosto(costo);
			a.setNombre(nombre);
			a.setProveedor(ProveedoresDB.getProveedorByNombre(proveedor));
			a.setStock(stockMaximo);
			a.setStockMinimo(stockMinimo);
			a.setSubcategoria(SubcategoriaDB.getSubcategoriaByNombre(subc));
			if (stockMinimo > stockMaximo) {
				a.setEstadoarticulo(EstadoArticuloDB.getEstadoById(2));
			} else {
				a.setEstadoarticulo(EstadoArticuloDB.getEstadoById(1));
			}
			tran.commit();
		} finally {
			sess.close();
		}

	}
}
