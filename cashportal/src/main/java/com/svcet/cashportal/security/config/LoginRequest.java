package com.svcet.cashportal.security.config;

public class LoginRequest {


	public LoginRequest() {
		super();
	}

	private String username;

	private String password;

	private String organization;

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
