package com.tirthal.learning.mapping.association.many2many;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show many-to-many association.
 * 
 * Run this program and check "M2M_STUDENT", "M2O_COURSE" and "M2M_STUDENT_COURSE" tables in database.
 * 
 * @author tirthalp
 * 
 */
public class TestManyToManyDemo {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestManyToManyDemo.class);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		logger.debug("*********************************************");
		try {
			
			Set<Course> javaCourses = new HashSet<Course>();
			javaCourses.add(new Course("Java 7"));
			javaCourses.add(new Course("Java 8"));
			javaCourses.add(new Course("JavaEE 7"));												
			
			Student student1 = new Student("Tirthal", javaCourses);
			session.save(student1);
			
			Student student2 = new Student("Akash", javaCourses);
			session.save(student2);
			
			Student student3 = new Student("Ritz");
			session.save(student3);
			
			Course springCourse = new Course("Spring Framework");	
			Set<Student> newSpringEnrollments = new HashSet<Student>();
			newSpringEnrollments.add(student1);
			newSpringEnrollments.add(student3);	
			springCourse.setStudents(newSpringEnrollments);
			session.save(springCourse);						
			
			tx.commit();

			logger.debug("Students and Courses data is saved successfully.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		session = HibernateUtil.getSessionFactory().openSession();		
		// Reading all courses enrolled by Tirthal student
		List<Course> tirthalCourses = session.createQuery("select students.courses from com.tirthal.learning.mapping.association.many2many.Student students where students.name = 'Tirthal'").list();
		logger.debug("Tirthal's courses:" + tirthalCourses);
		
		// Reading all students who subscribed to Spring Framework course
		List<Student> springStudents = session.createQuery("select courses.students from com.tirthal.learning.mapping.association.many2many.Course courses where courses.name = 'Spring Framework'").list();
		logger.debug("Spring framework course students:" + springStudents);
		
		session.close();
		
		logger.debug("*********************************************");
		HibernateUtil.shutdown();
	}

}
