package com.tirthal.learning.mapping.component;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show how employee (entity) and address (component) are mapped to single table in database.
 * 
 * Run this program and check "EMPLOYEE_ADDRESS" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TestComponentDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestComponentDemoApp.class);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		logger.debug("*********************************************");
		try {
			Address address1 = new Address("NYK Tower", "Dallas", "Texas", "59003");
			Employee employee1 = new Employee("Tirthal", "Patel", address1);
			session.save(employee1);
			
			Address address2 = new Address("NYK Tower", "Dallas", "Texas", "59003");
			Employee employee2 = new Employee("Ian", "Patel", address2);
			session.save(employee2);
			
			Address address3 = new Address("Infocity", "Gandhinar", "Gujarat", "200934");
			Employee employee3 = new Employee("John", "Nowak", address3);
			session.save(employee3);
			
			session.getTransaction().commit();
			
			logger.debug("Employee data is saved successfully.");
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.debug("*********************************************");
		
		// By default close hibernate session factory
		if(args!=null)
		{
			HibernateUtil.shutdown();
		}
	}
}
