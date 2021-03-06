package com.tirthal.learning.querying.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.mapping.component.Employee;
import com.tirthal.learning.mapping.component.TestComponentDemoApp;
import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo of basic usage of hibernate criteria using hibernate session.createCriteria API
 * 
 * @author tirthalp
 * 
 */
public class BasicCriteriaDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(BasicCriteriaDemoApp.class);

		// Creating "EMPLOYEE_ADDRESS" tables along with some data in database
		TestComponentDemoApp.main(null);

		// Getting employee data using Hibernate Criteria API
		System.out.println("-------------------------------------------------------------------------");
		Session session = HibernateUtil.getSessionFactory().openSession();

		logger.debug("(1) Display all employees:");
		// This will get all employees from "EMPLOYEE_ADDRESS", as "Employee" entity is mapped to it
		List<Employee> employees = (List<Employee>) session.createCriteria(Employee.class).list();
		for (Employee employee : employees) {
			logger.debug("Employee " + employee.getId() + " =" + employee);
		}
		
		logger.debug("(2) Display employee whose first name is 'Tirthal':");		
		// Here "firstName" is propertyName of "Employee" entity
		Employee tirthal = (Employee) session.createCriteria(Employee.class).add(Restrictions.eq("firstName", "Tirthal")).uniqueResult();
		logger.debug(tirthal.toString());

		logger.debug("(3) Display all employees whose last name is not 'Patel':");		
		// Here "lastName" is propertyName of "Employee" entity
		List<Employee> nonPatels = (List<Employee>) session.createCriteria(Employee.class).add(Restrictions.ne("lastName", "Patel")).list();
		for (Employee employee : nonPatels) {
			logger.debug("Employee " + employee.getId() + " =" + employee);
		}

		System.out.println("-------------------------------------------------------------------------");

		session.close();
		HibernateUtil.shutdown();
	}

}
