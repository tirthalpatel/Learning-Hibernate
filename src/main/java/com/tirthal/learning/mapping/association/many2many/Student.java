package com.tirthal.learning.mapping.association.many2many;

import java.util.HashSet;
import java.util.Set;

/**
 * Student POJO
 * 
 * @author tirthalp
 * 
 */
public class Student {

	private int id;
	private String name;
	private Set<Course> courses = new HashSet<Course>(0);

	public Student() {

	}

	public Student(String name) {		
		this.name = name;		
	}
	
	public Student(String name, Set<Course> courses) {		
		this.name = name;
		this.courses = courses;
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", total courses=" + courses.size() + "]";
	}
}
