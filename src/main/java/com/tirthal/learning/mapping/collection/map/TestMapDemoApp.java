package com.tirthal.learning.mapping.collection.map;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show how employee (entity) and certificate (value type map) are mapped to two tables in database.
 * 
 * Run this program and check "MAP_DEMO_EMPLOYEE" and "MAP_DEMO_CERTIFICATES" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TestMapDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestMapDemoApp.class);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		logger.debug("*********************************************");
		try {
			Employee e1 = new Employee("Tirthal", "Patel");
			Map<Integer, Certificate> m1 = new HashMap<Integer, Certificate>();
			m1.put(1, new Certificate("Java", 7000));
			m1.put(2, new Certificate("MS SQL", 10000));
			m1.put(3, new Certificate("J2EE", 8500));
			e1.setCertificates(m1);
			session.save(e1);

			Employee e2 = new Employee("Rakesh", "Goyani");
			Map<Integer, Certificate> m2 = new HashMap<Integer, Certificate>();
			m2.put(1, new Certificate("MS SQL", 10000));
			m2.put(2, new Certificate("Oracle", 15000));
			e2.setCertificates(m2);
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
