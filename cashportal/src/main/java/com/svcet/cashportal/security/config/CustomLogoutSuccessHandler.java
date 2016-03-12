package com.svcet.cashportal.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is invoked on a successful StellarUser Logout and sends the login page
 * URL as a response payload read from Application configuration for the client
 * to redirect
 * 
 * @author Sam Sundar K
 *
 */
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json;charset=UTF-8");
		//response.getWriter().print(mapper.writeValueAsString(tenantSelectionResponse));
		response.getWriter().flush();
	}
}
