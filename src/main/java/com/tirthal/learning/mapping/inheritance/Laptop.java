package com.tirthal.learning.mapping.inheritance;

/**
 * Laptop POJO
 * 
 * @author tirthalp
 * 
 */
public class Laptop extends Item {

	private String brand;
	private String modelNo;
	private String processorType;

	public Laptop() {
		super();
	}

	public Laptop(String itemCode, String itemName, String brand, String modelNo, String processorType) {
		super(itemCode, itemName);
		this.brand = brand;
		this.modelNo = modelNo;
		this.processorType = processorType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getProcessorType() {
		return processorType;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}

}
