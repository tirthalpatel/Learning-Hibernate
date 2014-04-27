package com.tirthal.learning.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Country POJO for basic demo of Hibernate annotations
 * 
 * @author tirthalp
 * 
 */
@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "C_NAME")
	private String name;

	public Country() {

	}

	public Country(int id, String name) {
		this.id = id;
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
		return "Country [id=" + id + ", name=" + name + "]";
	}

}
