package com.library.model;

public class User {
	private int user_id;
	private String name;
	private String email;
	private String phone_number;
	
	public User() {
		
	}
	public User(int user_id, String name, String email, String phone_number) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
	}
	public User(String name, String email, String phone_number) {
		super();
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", phone_number=" + phone_number
				+ "]";
	}
}
