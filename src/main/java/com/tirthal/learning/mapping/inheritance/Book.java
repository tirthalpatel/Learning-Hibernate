package com.tirthal.learning.mapping.inheritance;

/**
 * Book POJO
 * 
 * @author tirthalp
 * 
 */
public class Book extends Item {

	private String title;
	private String author;
	private String bookType;

	public Book() {
		super();
	}

	public Book(String itemCode, String itemName, String title, String author, String bookType) {
		super(itemCode, itemName);
		this.title = title;
		this.author = author;
		this.bookType = bookType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

}
