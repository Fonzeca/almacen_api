package com.mindia.almacen.persistence;

import org.hibernate.Session;

import com.mindia.almacen.model.Estadoarticulo;

public class EstadoArticuloDB {
	
	public static Estadoarticulo getEstadoById(int id) {
		Session sess = null;
		Estadoarticulo c=null;
		try {
			sess = HibernateUtils.openSession();;
			c= sess.get(Estadoarticulo.class, id);
			return c;
		}finally {
			sess.close();
		}
	}
}
