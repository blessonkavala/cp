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
 * 
 * @author Blesson
 *
 */
public class CashPortalAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	public CashPortalAuthenticationSuccessHandler() {
		super();
		setRedirectStrategy(new NoRedirectStrategy());
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		super.onAuthenticationSuccess(request, response, authentication);
		response.setContentType("application/json;charset=UTF-8");
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
