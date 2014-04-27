package com.tirthal.learning.mapping.collection.map;

import java.util.Map;

/**
 * Employee POJO
 * 
 * @author tirthalp
 * 
 */
public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private Map<Integer, Certificate> certificates;

	public Employee() {

	}

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Map<Integer, Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Map<Integer, Certificate> certificates) {
		this.certificates = certificates;
	}
}
