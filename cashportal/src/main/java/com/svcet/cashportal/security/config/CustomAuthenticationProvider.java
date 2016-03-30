package com.svcet.cashportal.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.service.UserService;

/**
 * Custom Authentication Provider Non DAO based. Temporary Solution to support
 * Custom {@link UsernamePasswordAuthenticationFilter}
 * 
 * @author Sam Sundar k
 *
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UserNamePasswordOrganizationAuthenticationToken authenticationToken = (UserNamePasswordOrganizationAuthenticationToken) authentication;
		final String userName = authenticationToken.getName();
		final String password = authenticationToken.getCredentials().toString();
		final String orgName = authenticationToken.getOrganization();
		UserMaster userMaster = userService.findUserByUserNamePasswordOrgName(userName, password, orgName);
		if (userMaster != null) {
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			final UserDetails principal = new CustomPrincipal(userName, password, grantedAuths);
			final Authentication auth = new UserNamePasswordOrganizationAuthenticationToken(principal, password,
					grantedAuths, orgName);
			return auth;
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UserNamePasswordOrganizationAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
