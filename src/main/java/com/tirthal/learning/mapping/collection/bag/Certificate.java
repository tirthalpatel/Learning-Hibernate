package com.tirthal.learning.mapping.collection.bag;

/**
 * Certificate POJO
 * 
 * @author tirthalp
 * 
 */
public class Certificate {

	private String name;
	private float price;

	public Certificate() {

	}

	public Certificate(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
