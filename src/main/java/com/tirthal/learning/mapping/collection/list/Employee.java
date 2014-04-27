package com.tirthal.learning.mapping.collection.list;

import java.util.List;

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
	private List<Certificate> certificates;

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

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}
}
