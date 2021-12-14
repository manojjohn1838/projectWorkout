package com.m2cafe.model;

import java.util.Objects;

public class User {
	
	private String name;
	private long mobile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, long mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "\nname=" + name + "\nmobile=" + mobile;
	}
	@Override
	public int hashCode() {
		return Objects.hash(mobile);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return mobile == other.mobile;
	}
	
	
	

}
