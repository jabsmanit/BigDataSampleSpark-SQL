package com.jabs.spark.sql.bean;

public class Customer {
	private int customerId;
	private String name;
	private String city;
	private String state;
	private int zipCode;
	
	
	public Customer(int customerId, String name, String city, String state,
			int zipCode) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
