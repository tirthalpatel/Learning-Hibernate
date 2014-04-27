package com.tirthal.learning.helloworld;

/**
 * This is Java POJO/Entity for basic mapping demo
 * 
 * @author tirthalp
 * 
 */
public class HelloWorld {

	private int id;
	private String message;

	
	public HelloWorld() {
		super();
	}

	public HelloWorld(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
