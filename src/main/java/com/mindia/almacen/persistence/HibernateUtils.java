package com.mindia.almacen.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	public static SessionFactory factory = null;
	
	public static Session openSession() {
		try {
			if(factory == null) {
				Configuration con = new Configuration().configure("hibernate.cfg.xml");
				factory = con.buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factory.openSession();
	}
	
}
