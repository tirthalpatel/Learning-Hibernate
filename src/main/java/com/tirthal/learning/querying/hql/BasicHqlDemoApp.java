package com.tirthal.learning.querying.hql;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.mapping.component.Employee;
import com.tirthal.learning.mapping.component.TestComponentDemoApp;
import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo of basic usage of Hibernate Query Language (HQL) using hibernate session.createQuery API
 * 
 * @author tirthalp
 * 
 */
public class BasicHqlDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(BasicHqlDemoApp.class);

		// Creating "EMPLOYEE_ADDRESS" tables along with some data in database
		TestComponentDemoApp.main(null);

		// Getting employee data using HQL
		System.out.println("-------------------------------------------------------------------------");
		Session session = HibernateUtil.getSessionFactory().openSession();

		logger.debug("(1) Display all employees:");
		// This will get all employees from "EMPLOYEE_ADDRESS", as "Employee" entity is mapped to it
		List<Employee> employees = session.createQuery("from com.tirthal.learning.mapping.component.Employee").list();
		for (Employee employee : employees) {
			logger.debug("Employee " + employee.getId() + " =" + employee);
		}
		
		logger.debug("(2) Display employee whose first name is 'Tirthal':");		
		// Here "firstName" is propertyName of "Employee" entity
		Employee tirthal = (Employee) session.createQuery("from com.tirthal.learning.mapping.component.Employee employee where employee.firstName = 'Tirthal'").uniqueResult();
		logger.debug(tirthal.toString());

		logger.debug("(3) Display all employees whose last name is not 'Patel':");		
		// Here "lastName" is propertyName of "Employee" entity
		List<Employee> nonPatels = session.createQuery("from com.tirthal.learning.mapping.component.Employee emp where emp.lastName != 'Patel'").list();
		for (Employee employee : nonPatels) {
			logger.debug("Employee " + employee.getId() + " =" + employee);
		}

		System.out.println("-------------------------------------------------------------------------");

		session.close();
		HibernateUtil.shutdown();
	}

}
