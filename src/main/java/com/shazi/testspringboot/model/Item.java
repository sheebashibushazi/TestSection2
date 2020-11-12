package com.shazi.testspringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private int price;
	private String description;
	private String brand;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int itemId, int price, String description, String brand) {
		super();
		this.itemId = itemId;
		this.price = price;
		this.description = description;
		this.brand = brand;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/*
	 * @Override public String toString() { return "Item [itemId=" + itemId +
	 * ", price=" + price + ", description=" + description + ", brand=" + brand +
	 * "]"; }
	 */
	

}
