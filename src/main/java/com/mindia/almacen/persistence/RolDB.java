package com.mindia.almacen.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mindia.almacen.model.Rol;

public class RolDB {

	public static List<Rol> getRoles() {
		Session sess = null;
		List<Rol> roles = null;

		try {

			sess = HibernateUtils.openSession();
			Query<Rol> query = sess.createQuery("select r from Rol r");
			roles = query.getResultList();
			return roles;
		} finally {
			sess.close();
		}
	}
	public static Rol getRolByNombre(String nombre) {
		Session sess=null;
		Rol rol=null;
		try {
			sess=HibernateUtils.openSession();
			Query<Rol> query=sess.createQuery("select r from Rol r where r.nombreRol='"+nombre+"'");
			rol=query.getSingleResult();
			return rol;
		}finally {
			sess.close();
		}
	}

}

