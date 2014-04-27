package com.tirthal.learning.querying.criteria;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.mapping.component.Employee;
import com.tirthal.learning.mapping.component.TestComponentDemoApp;
import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo of basic usage of hibernate criteria API
 * 
 * @author tirthalp
 * 
 */
public class BasicCriteriaDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(BasicCriteriaDemoApp.class);
		
		// Creating "EMPLOYEE_ADDRESS" tables along with some data in database
		TestComponentDemoApp.main(null);

		// Reading all employees using Hibernate Criteria API
		System.out.println("-------------------------------------------------------------------------");
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> employees = (List<Employee>) session.createCriteria(Employee.class).list();
		for(Employee employee : employees)
		{
			logger.debug("Employee " + employee.getId() + " =" + employee);
		}
		System.out.println("-------------------------------------------------------------------------");
		
		session.close();
		HibernateUtil.shutdown();
	}

}
