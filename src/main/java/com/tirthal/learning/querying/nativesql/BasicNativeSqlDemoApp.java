package com.tirthal.learning.querying.nativesql;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.mapping.component.Employee;
import com.tirthal.learning.mapping.component.TestComponentDemoApp;
import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo of basic usage of Native SQL using hibernate session.createSQLQuery API
 * 
 * @author tirthalp
 * 
 */
public class BasicNativeSqlDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(BasicNativeSqlDemoApp.class);

		// Creating "EMPLOYEE_ADDRESS" tables along with some data in database
		TestComponentDemoApp.main(null);

		// Getting employee data using Native SQL queries - "hibernate_quick_start" is db name
		// Below queries are tested with MySQL DB and may break if different database is used
		System.out.println("-------------------------------------------------------------------------");
		Session session = HibernateUtil.getSessionFactory().openSession();

		logger.debug("(1) Display all employees:");		
		List<Employee> employees = session.createSQLQuery("SELECT * FROM hibernate_quick_start.EMPLOYEE_ADDRESS").addEntity(Employee.class).list();
		for (Employee employee : employees) {
			logger.debug("Employee " + employee.getId() + " =" + employee);
		}
		
		logger.debug("(2) Display employee whose first name is 'Tirthal':");				
		Employee tirthal = (Employee) session.createSQLQuery("SELECT * FROM hibernate_quick_start.EMPLOYEE_ADDRESS WHERE FIRSTNAME = 'Tirthal'").addEntity(Employee.class).uniqueResult();
		logger.debug(tirthal.toString());

		logger.debug("(3) Display all employees whose last name is not 'Patel':");				
		List<Employee> nonPatels = session.createSQLQuery("SELECT * FROM hibernate_quick_start.EMPLOYEE_ADDRESS WHERE LASTNAME != 'Patel'").addEntity(Employee.class).list();
		for (Employee employee : nonPatels) {
			logger.debug("Employee " + employee.getId() + " =" + employee);
		}

		System.out.println("-------------------------------------------------------------------------");

		session.close();
		HibernateUtil.shutdown();
	}

}
