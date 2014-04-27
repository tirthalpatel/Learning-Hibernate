package com.tirthal.learning.mapping.collection.bag;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show how employee (entity) and certificate (value type collection) are mapped to two tables in database.
 * 
 * Run this program and check "BAG_DEMO_EMPLOYEE" and "BAG_DEMO_CERTIFICATES" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TestBagDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestBagDemoApp.class);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		logger.debug("*********************************************");
		try {
			Employee e1 = new Employee("Tirthal", "Patel");
			Collection<Certificate> c1 = new ArrayList<Certificate>();
			c1.add(new Certificate("Java", 7000));
			c1.add(new Certificate("MS SQL", 10000));
			c1.add(new Certificate("J2EE", 8500));
			e1.setCertificates(c1);
			session.save(e1);

			Employee e2 = new Employee("Rakesh", "Goyani");
			Collection<Certificate> c2 = new ArrayList<Certificate>();
			c2.add(new Certificate("MS SQL", 10000));
			c2.add(new Certificate("Oracle", 15000));
			e2.setCertificates(c2);
			session.save(e2);

			tx.commit();

			logger.debug("Employee and certificates data is saved successfully.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.debug("*********************************************");
		HibernateUtil.shutdown();
	}

}
