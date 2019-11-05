package com.water.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.water.util.LoggerManager;

public class BaseHibernateDAO {
	static Session session = null;

	public static Session getSession() {
		try {

			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			System.out.println("Connectedddddddddddd");

		} catch (HibernateException se) {
			System.out.println(se);
			LoggerManager.writeLogWarning(se);
		} catch (Exception cnfe) {
			LoggerManager.writeLogWarning(cnfe);
			System.out.println(cnfe);
		}
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			try {
				session.flush();
				session.close();
			} catch (HibernateException e) {
				LoggerManager.writeLogSevere(e);
				e.printStackTrace();
			}
		}
	}

}
