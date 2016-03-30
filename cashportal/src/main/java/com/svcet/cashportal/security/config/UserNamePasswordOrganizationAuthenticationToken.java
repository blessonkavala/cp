package com.svcet.cashportal.security.config;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

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

	public UserNamePasswordOrganizationAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities, String organization) {
		super(principal, credentials, authorities);
		this.organization = organization;
	}

}
