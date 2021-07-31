package net.session.login;

import java.io.Serializable;

public class loginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname;
	private String password;

	public String getUsername() {
		return fname;
	}

	public void setUsername(String fname) {
		this.fname = fname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}