package com.mindia.almacen.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mindia.almacen.model.Llave;

public class LlaveDB {
	public static void crearLlave(Llave llave) {
		Session sess = null;
		Transaction trans = null;
		try {
			sess = HibernateUtils.openSession();
			trans = sess.beginTransaction();
			sess.save(llave);
			trans.commit();
		} finally {
			sess.close();
		}
	}

	public static Llave getLlaveByIdentificacion(Integer id, String nombre) {
		Session sess = null;
		Llave llave = null;
		try {
			sess = HibernateUtils.openSession();
			Query<Llave> query = sess
					.createQuery("select l from Llave l where l.llaveId='" + id + "' and l.nombre='" + nombre + "'");
			llave = query.getSingleResult();
			return llave;
		} finally {
			sess.close();
		}
	}
}
