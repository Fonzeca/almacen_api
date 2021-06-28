package com.mindia.almacen.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mindia.almacen.model.Equipo;
import com.mindia.almacen.model.Usuario;

public class EquipoDB {

	public static Serializable crearEquipo(Equipo equipo) {
		Session sess = null;
		Transaction tran = null;
		try {
			sess = HibernateUtils.openSession();
			tran = sess.beginTransaction();
			Serializable s = sess.save(equipo);
			tran.commit();
			return s;

		} finally {
			sess.close();
		}
	}

	public static void cambiarEstado(Equipo equipo) {
		Session sess = null;
		Transaction tran = null;
		try {
			sess = HibernateUtils.openSession();
			tran = sess.beginTransaction();

			sess.update(equipo);

			tran.commit();
		} finally {
			sess.close();
		}
	}

	public static Equipo getEquipoByID(int equip) {
		Session sess = null;
		Equipo e;
		try {
			sess = HibernateUtils.openSession();
			e = sess.get(Equipo.class, equip);
			Hibernate.initialize(e.getTipo().getNombre());
			Hibernate.initialize(e.getLugar().getNombre());
			if (e.getUsuario() != null) {

				Hibernate.initialize(e.getUsuario().getNombre());
			}
			return e;
		} finally {
			sess.close();
		}
	}

	public static List<Equipo> getListaEquiposCompleta() {
		Session sess = null;
		List<Equipo> lista = new ArrayList<Equipo>();
		try {
			sess = HibernateUtils.openSession();
			Query<Equipo> query = sess.createQuery("select e from Equipo e");
			lista = query.getResultList();
			for (Equipo e : lista) {
				Hibernate.initialize(e.getLugar());
				Hibernate.initialize(e.getTipo());
				Hibernate.initialize(e.getUsuario());
				Hibernate.initialize(e);
			}
			return lista;
		} finally {
			sess.close();
		}
	}

	public static List<Equipo> getListaEquipos() {
		Session sess = null;
		List<Equipo> lista = new ArrayList<Equipo>();
		try {
			sess = HibernateUtils.openSession();
			Query<Equipo> query = sess.createQuery("select e from Equipo e where e.activo=1");
			lista = query.getResultList();
			for (Equipo e : lista) {
				Hibernate.initialize(e.getLugar());
				Hibernate.initialize(e.getTipo());
				Hibernate.initialize(e.getUsuario());
				Hibernate.initialize(e);
			}
			return lista;
		} finally {
			sess.close();
		}
	}

	public static List<Equipo> getListaEquiposByUsuario(Usuario user) {
		Session sess = null;
		List<Equipo> lista = new ArrayList<Equipo>();
		try {
			sess = HibernateUtils.openSession();
			Query<Equipo> query = sess.createQuery("select e from Equipo e where e.activo=1 and e.usuario=" + user);
			lista = query.getResultList();
			for (Equipo e : lista) {
				Hibernate.initialize(e.getLugar());
				Hibernate.initialize(e.getTipo());
				Hibernate.initialize(e.getUsuario());
				Hibernate.initialize(e);
			}
			return lista;
		} finally {
			sess.close();
		}
	}
}
