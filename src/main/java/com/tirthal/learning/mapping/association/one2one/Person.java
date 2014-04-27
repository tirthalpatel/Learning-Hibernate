package com.tirthal.learning.mapping.association.one2one;

/**
 * Person POJO
 * 
 * @author tirthalp
 * 
 */
public class Person {

	private int id;
	private String name;
	private Passport passport;

	public Person() {

	}

	public Person(String name) {
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", passport=" + passport.getId() + "]";
	}

}
