package com.tirthal.learning.mapping.association.many2many;

import java.util.HashSet;
import java.util.Set;

/**
 * Course POJO
 * 
 * @author tirthalp
 * 
 */
public class Course {

	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>(0);

	public Course() {

	}

	public Course(String name) {		
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
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", total students=" + students.size() + "]";
	}

}
