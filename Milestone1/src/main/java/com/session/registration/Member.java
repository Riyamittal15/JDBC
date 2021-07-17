package com.session.registration;

public class Member {
	private String fname;
	private String email;
	private String phone;
	private String password;
	
	
	public Member() {
		super();
	}

	public Member(String fname, String email, String phone, String password) {
		super();
		this.fname = fname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
