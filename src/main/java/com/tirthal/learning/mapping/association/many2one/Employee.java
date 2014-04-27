package com.tirthal.learning.mapping.association.many2one;

/**
 * Employee POJO
 * 
 * @author tirthalp
 * 
 */
public class Employee {

	private int id;
	private String name;
	private Company company;

	public Employee() {

	}

	public Employee(String name, Company company) {
		this.name = name;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
}
