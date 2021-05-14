package com.mindia.almacen.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mindia.almacen.model.GrupoLlaves;

public class GrupoDB {
	public static void crearGrupo(GrupoLlaves grupo) {
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

	public static GrupoLlaves getGrupoByName(String nombre) {
		Session sess = null;
		GrupoLlaves grupo = null;
		try {
			sess = HibernateUtils.openSession();
			Query<GrupoLlaves> query = sess.createQuery("select g from Grupo g where g.nombre='" + nombre + "'");
			grupo = query.getSingleResult();
			return grupo;
		} finally {
			sess.close();
		}
	}

}
