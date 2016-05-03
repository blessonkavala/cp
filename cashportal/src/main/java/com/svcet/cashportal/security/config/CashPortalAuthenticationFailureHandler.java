package com.svcet.cashportal.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svcet.cashportal.web.beans.ErrorModel;

/**
 * 
 * @author Blesson
 * 
 *         This class invoked on a Authentication Failure and sends
 *         {@link HttpServletResponse.SC_UNAUTHORIZED} as Http response status
 *         code
 *
 */
public class CashPortalAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		ErrorModel errorModel= new ErrorModel("Invalid Loginn Credentials");
		response.getWriter().print(mapper.writeValueAsString(errorModel));
		response.getWriter().flush();
	}
}
