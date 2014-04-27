package com.tirthal.learning.mapping.collection.set;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show how employee (entity) and certificate (value type set) are mapped to two tables in database.
 * 
 * Run this program and check "SET_DEMO_EMPLOYEE" and "SET_DEMO_CERTIFICATES" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TestSetDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestSetDemoApp.class);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		logger.debug("*********************************************");
		try {
			Employee e1 = new Employee("Tirthal", "Patel");
			Set<Certificate> c1 = new HashSet<Certificate>();
			c1.add(new Certificate(1, "Java"));
			c1.add(new Certificate(2, "MS SQL"));
			c1.add(new Certificate(3, "J2EE"));
			e1.setCertificates(c1);
			session.save(e1);

			Employee e2 = new Employee("Rakesh", "Goyani");
			Set<Certificate> c2 = new HashSet<Certificate>();
			c2.add(new Certificate(1, "MS SQL"));
			c2.add(new Certificate(2, "Oracle"));
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
