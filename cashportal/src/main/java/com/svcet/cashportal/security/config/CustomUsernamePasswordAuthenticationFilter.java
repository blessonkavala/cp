package com.svcet.cashportal.security.config;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Sam Sundar K
 *
 */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public static final String SECURITY_FROM_ORGANIZATION_NAME_KEY = "tenantid";

	public static final Logger LOGGER = LoggerFactory.getLogger(CustomUsernamePasswordAuthenticationFilter.class);
	
	private boolean postOnly = true;

	public CustomUsernamePasswordAuthenticationFilter() {
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/security/login", "POST"));
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		String userName = (String) request.getAttribute(SPRING_SECURITY_FORM_USERNAME_KEY);
		request.removeAttribute(SPRING_SECURITY_FORM_USERNAME_KEY);
		return userName;
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		String password = (String) request.getAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY);
		request.removeAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY);
		return password;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (postOnly && !request.getMethod().equals("POST")) {
				throw new AuthenticationServiceException(
						"Authentication method not supported: " + request.getMethod());
			}
			/*
			 * HttpServletRequest can be read only once
			 */
			StringBuffer sb = new StringBuffer();
			String line = null;

			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			// json transformation
			ObjectMapper mapper = new ObjectMapper();

			LoginRequest loginRequest = mapper.readValue(sb.toString(), LoginRequest.class);
			request.setAttribute(SPRING_SECURITY_FORM_USERNAME_KEY, loginRequest.getUsername());
			request.setAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY, loginRequest.getPassword());
			request.setAttribute(SECURITY_FROM_ORGANIZATION_NAME_KEY, loginRequest.getOrganization());
			

			UserNamePasswordOrganizationAuthenticationToken authRequest = new UserNamePasswordOrganizationAuthenticationToken(
					loginRequest.getUsername(), loginRequest.getPassword(),loginRequest.getOrganization());

			// Allow subclasses to set the "details" property
			setDetails(request, authRequest);

			return this.getAuthenticationManager().authenticate(authRequest);
			

		} catch (Exception e) {
			LOGGER.error("---->", e);
			// LOG.error("Error while transforming login request", e);
		}
		return super.attemptAuthentication(request, response);
	}

}
