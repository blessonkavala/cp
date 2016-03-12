package com.svcet.cashportal.security.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserNamePasswordOrganizationAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private String organization;;

	public String getOrganization() {
		return organization;
	}

	public UserNamePasswordOrganizationAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public UserNamePasswordOrganizationAuthenticationToken(Object principal, Object credentials, String organization) {
		super(principal, credentials);
		this.organization = organization;
	}
}
