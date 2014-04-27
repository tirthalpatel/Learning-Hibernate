package com.tirthal.learning.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hibernate utility
 * 
 * @author tirthalp
 * 
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

			return configuration.buildSessionFactory(serviceRegistry);

		} catch (HibernateException ex) {
			// Make sure you log the exception, as it might be swallowed
			logger.error("Initial SessionFactory creation failed - " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Get instance of Hibernate SessionFactory
	 * 
	 * @return single instance of hibernate SessionFactory instance
	 */
	public static SessionFactory getSessionFactory() {		
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
