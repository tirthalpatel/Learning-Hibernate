package com.tirthal.learning.mapping.collection.list;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show how employee (entity) and certificate (value type list) are mapped to two tables in database.
 * 
 * Run this program and check "LIST_DEMO_EMPLOYEE" and "LIST_DEMO_CERTIFICATES" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TestListDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestListDemoApp.class);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		logger.debug("*********************************************");
		try {
			Employee e1 = new Employee("Tirthal", "Patel");
			List<Certificate> c1 = new ArrayList<Certificate>();
			c1.add(new Certificate(1, "Java"));
			c1.add(new Certificate(2, "MS SQL"));
			c1.add(new Certificate(3, "J2EE"));
			e1.setCertificates(c1);
			session.save(e1);

			Employee e2 = new Employee("Rakesh", "Goyani");
			List<Certificate> c2 = new ArrayList<Certificate>();
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
