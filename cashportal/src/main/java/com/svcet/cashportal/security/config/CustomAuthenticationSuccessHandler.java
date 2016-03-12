package com.svcet.cashportal.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class gets invoked upon the successful Authentication, and returns the
 * list of Tenants associated for the selected user as a payload
 * 
 * @author Sam Sundar k
 *
 */
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private LoginSuccessResponse loginSuccessResponse;

	public CustomAuthenticationSuccessHandler() {
		super();
		setRedirectStrategy(new NoRedirectStrategy());
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		super.onAuthenticationSuccess(request, response, authentication);
		ObjectMapper mapper = new ObjectMapper();

		response.setContentType("application/json;charset=UTF-8");
		//response.getWriter().print(mapper.writeValueAsString(loginSuccessResponse.getTenants()));
		response.getWriter().flush();
	}

	protected class NoRedirectStrategy implements RedirectStrategy {

		@Override
		public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url)
				throws IOException {
			// no redirect
		}

	}
}
