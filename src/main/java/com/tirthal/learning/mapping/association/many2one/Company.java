package com.tirthal.learning.mapping.association.many2one;

/**
 * Company POJO
 * 
 * @author tirthalp
 * 
 */
public class Company {

	private int id;
	private String name;

	public Company() {

	}

	public Company(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
}
