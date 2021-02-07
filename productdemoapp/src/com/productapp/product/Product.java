package com.productapp.product;

import java.util.Date;

public class Product {
	private int id;
	private String name;
	private int price;
	private int quantity;
	private Date mandate;
	private Date insdob;
	

	public Product() {}
	
	public Product(String name, int price, int quantity,Date mandate, Date insdob) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.mandate = mandate;
		this.insdob = insdob;
	}

	public Product(int id, String name, int price, int quantity, Date mandate, Date insdob) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.mandate = mandate;
		this.insdob = insdob;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getMandate() {
		return mandate;
	}

	public void setMandate(Date mandate) {
		this.mandate = mandate;
	}

	public Date getInsdob() {
		return insdob;
	}

	public void setInsdob(Date insdob) {
		this.insdob = insdob;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", mandate="
				+ mandate + ", insdob=" + insdob + "]";
	}
	
	
	
}
