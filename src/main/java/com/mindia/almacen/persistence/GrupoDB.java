package com.mindia.almacen.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mindia.almacen.model.Grupo;

public class GrupoDB {
	public static void crearGrupo(Grupo grupo) {
		Session sess = null;
		Transaction trans = null;
		try {
			sess = HibernateUtils.openSession();
			trans = sess.beginTransaction();
			sess.save(grupo);
			trans.commit();
		} finally {
			sess.close();
		}
	}

	public static Grupo getGrupoByName(String nombre) {
		Session sess = null;
		Grupo grupo = null;
		try {
			sess = HibernateUtils.openSession();
			Query<Grupo> query = sess.createQuery("select g from Grupo g where g.nombre='" + nombre + "'");
			grupo = query.getSingleResult();
			return grupo;
		} finally {
			sess.close();
		}
	}

}
