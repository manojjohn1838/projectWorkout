package com.m2cafe.model;

import java.util.Objects;

public class Products {
	
	private String name;
	private String description;
	private double price;
	private String status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(String name, String description, double price, String status) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
	}
	@Override
	public String toString() {
		return "\nname=" + name + "\nDescription=" + description + "\nPrice=" + price + "\nStatus=" + status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	

}
