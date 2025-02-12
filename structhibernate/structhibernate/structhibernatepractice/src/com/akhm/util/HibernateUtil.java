package com.akhm.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private HibernateUtil() {

	}

	private static SessionFactory sessFact;

	// Step1:loading configuration
	static {
		try {
			Configuration cfg = new Configuration()
					.configure("Hibernate.cfg.xml");
			// connection of configuration
			sessFact = cfg.buildSessionFactory();
		} catch (Throwable t) {
			throw new ExceptionInInitializerError(t);
		}
	}

	// Step2: connection
	public static SessionFactory getSessionFactory() {
		if (sessFact == null) {
			try {
				Configuration cfg = new Configuration()
						.configure("Hibernate.cfg.xml");
				// connection of configuration
				sessFact = cfg.buildSessionFactory();
			} catch (Throwable t) {
				throw new ExceptionInInitializerError(t);
			}

		}
		return sessFact;
	}

	// get connetion
	private static final ThreadLocal<Session> threadLocalSession = new ThreadLocal<Session>();

	public static Session getSession() {
		Session session = threadLocalSession.get();
		if (session == null || !session.isOpen()) {
			session = getSessionFactory().openSession();
			threadLocalSession.set(session);
		}
		return session;
	}
//reusability component
	public static void closeSession() {
		Session session = threadLocalSession.get();
		if (session != null && session.isOpen()) {
			session.close();
			threadLocalSession.remove();
		}
	}

	public static Serializable save(Object entity) {
		Serializable primarykey = null;
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		primarykey = session.save(entity);
		tx.commit();
		return primarykey;
	}
}
