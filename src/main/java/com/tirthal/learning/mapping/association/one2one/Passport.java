package com.tirthal.learning.mapping.association.one2one;

/**
 * Passport POJO
 * 
 * @author tirthalp
 * 
 */
public class Passport {

	private int id;
	private String number;
	private Person person;

	public Passport() {

	}
	
	public Passport(String number, Person person) {
		this.number = number;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", person=" + person.getId() + "]";
	}
	
}
