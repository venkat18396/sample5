package com.caps.dto;

public class Person {
	
	private String regno;
	private String firstname;
	private String lastname;
	private String password;
	private String isAdmin;
	
	
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Person [regno=" + regno + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
}
