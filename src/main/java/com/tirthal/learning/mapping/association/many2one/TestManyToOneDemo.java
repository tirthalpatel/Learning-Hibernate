package com.tirthal.learning.mapping.association.many2one;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show many-to-one association.
 * 
 * Run this program and check "M2O_EMPLOYEE" and "M2O_COMPANY" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TestManyToOneDemo {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestManyToOneDemo.class);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		logger.debug("*********************************************");
		try {

			Company c1 = new Company("Ibbmt");
			Company c2 = new Company("Accemmture");
			session.save(c1);
			session.save(c2);

			Employee e1 = new Employee("Rakhkk", c1);
			session.save(e1);
			Employee e2 = new Employee("Tikka", c1);
			session.save(e2);
			Employee e3 = new Employee("Johnn", c2);
			session.save(e3);
			Employee e4 = new Employee("Amman", c1);
			session.save(e4);
			Employee e5 = new Employee("Rukhsi", c2);
			session.save(e5);

			tx.commit();

			logger.debug("Company and Employees data is saved successfully.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		// Reading employees of company name = "Ibbmt"
		session = HibernateUtil.getSessionFactory().openSession();		
		List<Employee> employees = session.createQuery("from com.tirthal.learning.mapping.association.many2one.Employee employee where employee.company.name = 'Ibbmt'").list();		
		logger.debug("Employees:" + employees);		
		session.close();
		
		logger.debug("*********************************************");
		HibernateUtil.shutdown();
	}

}
