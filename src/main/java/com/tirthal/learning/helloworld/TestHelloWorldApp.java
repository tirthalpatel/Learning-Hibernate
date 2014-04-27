package com.tirthal.learning.helloworld;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Hello World demo of basic mapping between Java entity and SQL table using Hibernate to save, get/load, update and read some data
 * 
 * @author tirthalp
 * 
 */
public class TestHelloWorldApp {

	public static void main(String[] args) {

		final Logger logger = LoggerFactory.getLogger(TestHelloWorldApp.class);

		// -------> Save some data in to database
		logger.debug("*********************************************");
		Session firstSession = HibernateUtil.getSessionFactory().openSession();
		firstSession.beginTransaction();

		try {
			HelloWorld hw1 = new HelloWorld(1, "Hello World 2003");
			firstSession.save(hw1);

			HelloWorld hw2 = new HelloWorld();
			hw2.setId(2);
			hw2.setMessage("Hello World 2005");
			firstSession.save(hw2);

			firstSession.getTransaction().commit(); // commit the transaction
		} catch (HibernateException e) {
			if (firstSession.getTransaction() != null)
				firstSession.getTransaction().rollback(); // rollback the transaction, if error occurs
			e.printStackTrace();
		} finally {
			firstSession.close(); // close hibernate session
		}

		// ------> Get/Load data from database and update - only minor difference in session.get() and session.load()
		logger.debug("*********************************************");
		Session secondSession = HibernateUtil.getSessionFactory().openSession();
		Transaction secondTx = secondSession.beginTransaction();

		try {
			// If you use get() and id doesn't existing in database, you would get null
			HelloWorld hw3 = (HelloWorld) secondSession.get(HelloWorld.class, 1);
			logger.debug("Get from database --- Id: " + hw3.getId() + ", Message:" + hw3.getMessage());

			// If you use load() and id doesn't exist in database, then you would get org.hibernate.ObjectNotFoundException
			HelloWorld hw4 = (HelloWorld) secondSession.load(HelloWorld.class, 2);
			logger.debug("Load from database --- Id: " + hw4.getId() + ", Message:" + hw4.getMessage());

			// When you update value in java entity, hibernate will also update the same in database on session transaction commit
			hw3.setMessage("Hello World 2003 - updated");
			hw4.setMessage("Hello World 2005 - updated");

			secondTx.commit(); // commit the transaction
		} catch (HibernateException e) {
			if (secondTx != null)
				secondTx.rollback(); // rollback the transaction, if error occurs
			e.printStackTrace();
		} finally {
			secondSession.close(); // close hibernate session
		}

		// -------> Read all records of "HelloWorld" using HQL - hibernate query language
		logger.debug("*********************************************");

		Session thirdSession = HibernateUtil.getSessionFactory().openSession();
		List<HelloWorld> hwList = thirdSession.createQuery("from HelloWorld").list();
		logger.debug("Total hello world message found = " + hwList.size());

		for (HelloWorld hw : hwList) {
			logger.debug("Hello World - Id: " + hw.getId() + ", Message: " + hw.getMessage());
		}

		thirdSession.clear();

		// --------> Close hibernate sessionfactory
		logger.debug("*********************************************");

		HibernateUtil.shutdown();
	}
}
