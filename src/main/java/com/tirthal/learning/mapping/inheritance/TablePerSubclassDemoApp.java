package com.tirthal.learning.mapping.inheritance;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show in case of Table Per Subclass, subclass mapped tables are related to parent class mapped table by primary key
 * and foreign key relationship.
 * 
 * Run this program and check "TPS_ITEM", "TPS_BOOK" and "TPS_LAPTOP" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TablePerSubclassDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TablePerSubclassDemoApp.class);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		logger.debug("*********************************************");
		try {

			Item item1 = new Item("I#001", "item 001");
			Book book1 = new Book("B#001", "book 001", "Learning made easy", "Tirthal Patel", "General");
			Laptop laptop1 = new Laptop("L#001", "laptop 001", "Compaq", "Compaq 510", "Intel Core 2 Duo");

			session.save(item1);
			session.save(book1);
			session.save(laptop1);

			session.getTransaction().commit();

			logger.debug("Item, Book and Laptop data is saved successfully.");
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.debug("*********************************************");

		HibernateUtil.shutdown();
	}
}
