package com.m2cafe.model;

import java.util.Objects;

public class Invoice {
	
	private Products product;
	private User user;
	private double finalPrice;
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
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(Products product, User user, double finalPrice) {
		super();
		this.product = product;
		this.user = user;
		this.finalPrice = finalPrice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(finalPrice, product, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Double.doubleToLongBits(finalPrice) == Double.doubleToLongBits(other.finalPrice)
				&& Objects.equals(product, other.product) && Objects.equals(user, other.user);
	}
	
	

}
