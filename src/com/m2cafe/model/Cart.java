package com.m2cafe.model;

import java.util.Objects;

public class Cart {
	
	private Products product;
	private User user;
	private int quantity;
	private double totalPrice;
	
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return totalPrice;
	}
	public void setPrice(double price) {
		this.totalPrice = price;
	}
	public Cart(Products product, User user, int quantity, double price) {
		super();
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.totalPrice = price;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(totalPrice, product, quantity, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Objects.equals(product, other.product) && quantity == other.quantity
				&& Objects.equals(user, other.user);
	}
	
	

}
