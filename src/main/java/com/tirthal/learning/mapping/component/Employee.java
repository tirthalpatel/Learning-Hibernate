package com.tirthal.learning.mapping.component;

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
	private Address address;

	public Employee() {

	}

	public Employee(String firstName, String lastName, Address address) {				
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
	
	

}
