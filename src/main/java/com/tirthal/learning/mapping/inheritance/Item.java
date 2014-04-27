package com.tirthal.learning.mapping.inheritance;

/**
 * Item POJO
 * 
 * @author tirthalp
 * 
 */
public class Item {

	private long id;
	private String itemCode;
	private String itemName;

	public Item(String itemCode, String itemName) {
		this.itemCode = itemCode;
		this.itemName = itemName;
	}

	public Item() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
