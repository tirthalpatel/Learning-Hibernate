package com.tirthal.learning.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo of basic usage of annotations
 * 
 * @author tirthalp
 * 
 */
public class TestAnnotationsDemoApp {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestAnnotationsDemoApp.class);

		CountryDao countryDao = new CountryDao();

		// Save country
		int countryId1 = countryDao.saveCountry("India");
		int countryId2 = countryDao.saveCountry("Chin");
		int countryId3 = countryDao.saveCountry("Australia");
		logger.debug("Countries saved successfully with IDs = " + countryId1 + "," + countryId2 + "," + countryId3);
		// List all countries
		logger.debug("All countries = " + countryDao.listCountries());
		logger.debug("-------------");

		// Update country name
		if (countryDao.updateCountry(countryId2, "China"))
			logger.debug("Successfully updated from 'Chin' to 'China'");
		else
			logger.error("Failed to update from 'Chin' to 'China'");
		// List all countries
		logger.debug("All countries = " + countryDao.listCountries());
		logger.debug("-------------");

		// Delete country
		if (countryDao.deleteCountry(countryId2))
			logger.debug("Successfully deleted China");
		else
			logger.error("Failed to delete China");
		// List all countries
		logger.debug("All countries = " + countryDao.listCountries());

		HibernateUtil.shutdown();
	}

}
