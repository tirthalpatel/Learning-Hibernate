package com.tirthal.learning;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * This is Test application to check that your database configuration is correct and hibernate is able to establish
 * connection with database!
 * 
 * @author tirthalp
 * @see com.tirthal.learning.util.HibernateUtil
 */
public class TestDbConnectionApp {	
	
	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestDbConnectionApp.class);
		
		logger.debug("Hello World - Testing Hibernate Connection!");
		logger.debug("Establishing session connection....");	
		
		// Get the session to perform CRUD operation with database
		Session session = HibernateUtil.getSessionFactory().openSession(); // Explore code of *HibernateUtil*

		// Do nothing, as this is for testing successful database connectivity only
		logger.debug("Got session connection successfully & now closing session connection....");		
		
		// Close the session
		session.close();

		logger.debug("Session closed successfully & now closing session factory connection....");		
		
		// Finally close Hibernate's SessionFactory
		HibernateUtil.shutdown();
		
		logger.debug("Closed session factory connection....");		
	}
}
