package com.tirthal.learning.annotations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.tirthal.learning.util.HibernateUtil;

/**
 * An example of how to select, update, insert and delete a Country using Hibernate
 * 
 * @author tirthalp
 * 
 */
public class CountryDao {
	
	public Integer saveCountry(String name) {
		Integer countryId = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			Country country = new Country();
			country.setName(name);

			countryId = (Integer) session.save(country);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return countryId;
	}

	public boolean updateCountry(int id, String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			Country country = (Country) session.get(Country.class, id);
			if(country != null) {
				country.setName(name);
				session.getTransaction().commit();
			} else {
				return false;
			}							
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return true;
	}
	
	public boolean deleteCountry(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			Country country = (Country) session.get(Country.class, id);
			if(country != null) {
				session.delete(country);
				session.getTransaction().commit();
			} else {
				return false;
			}							
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Country> listCountries() {		
		Session session = HibernateUtil.getSessionFactory().openSession();		

		List<Country> countries = new ArrayList<Country>();
		try {
			countries = (List<Country>) session.createCriteria(Country.class).list();
		} catch (HibernateException e) {			
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return countries;
	}
}
