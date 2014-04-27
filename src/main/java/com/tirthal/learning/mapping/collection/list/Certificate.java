package com.tirthal.learning.mapping.collection.list;

/**
 * Certificate POJO
 * 
 * @author tirthalp
 * 
 */
public class Certificate {

	private int id;
	private String certiName;

	public Certificate() {

	}

	public Certificate(int id, String certiName) {
		this.id = id;
		this.certiName = certiName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCertiName() {
		return certiName;
	}

	public void setCertiName(String certiName) {
		this.certiName = certiName;
	}
}
