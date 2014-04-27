package com.tirthal.learning.mapping.association.one2one;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show one-to-one association.
 * 
 * Run this program and check "O2O_PERSON" and "O2O_PASSPORT" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TestOneToOneDemo {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestOneToOneDemo.class);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		logger.debug("*********************************************");
		try {

			Person person1 = new Person("Tirthal");
			Passport passport1 = new Passport("AZFG2SEDXHGNGHG29D", person1);
			person1.setPassport(passport1);
			session.save(person1);

			Person person2 = new Person("Salman");
			Passport passport2 = new Passport("SX2DD9KDLW234SSS", person2);
			person2.setPassport(passport2);
			session.save(person2);

			tx.commit();

			logger.debug("Person and Passport data is saved successfully.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		session = HibernateUtil.getSessionFactory().openSession();
		// Reading person having name = "Tirthal"
		Person person = (Person) session.createCriteria(Person.class).add(Restrictions.eq("name", "Tirthal")).uniqueResult();
		logger.debug("Person = ID:" + person.getId() + ", Name:" + person.getName() + ", Passport:" + person.getPassport());		
		// Reading passport having number = "SX2DD9KDLW234SSS"
		Passport passport = (Passport) session.createCriteria(Passport.class).add(Restrictions.eq("number", "SX2DD9KDLW234SSS")).uniqueResult();
		logger.debug("Passport = ID:" + passport.getId() + ", Number:" + passport.getNumber() + ", Person:" + passport.getPerson());
		session.close();

		logger.debug("*********************************************");
		HibernateUtil.shutdown();
	}

}
