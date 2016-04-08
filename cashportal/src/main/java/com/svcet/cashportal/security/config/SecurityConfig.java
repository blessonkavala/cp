package com.svcet.cashportal.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;

/**
 * 
 * @author Blesson
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		// TODO:CHECK LATER
		http.formLogin().loginPage("/login.html").failureUrl("/login.html?error").permitAll().and().logout()
				.logoutSuccessHandler(customLogoutSuccessHandler()).logoutUrl("/login.html?logout").permitAll().and()
				.headers().contentTypeOptions().disable().and().authorizeRequests()
				.antMatchers("/*.js", "/*.css", "/*.html", "/fonts/**", "/img/**", "/css/**", "/bower_components/**",
						"/app/**")
				.permitAll().and().authorizeRequests().anyRequest().authenticated().and().requestCache()
				.requestCache(new NullRequestCache()).and().exceptionHandling()
				.authenticationEntryPoint(customAuthenticationEntryPoint()).and().httpBasic().disable()
				.addFilter(customUsernamePasswordAuthenticationFilter());

		http.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint());

		// http.authorizeRequests().anyRequest().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.authenticationProvider(customAuthenticationProvider());
	}

	@Bean
	public AuthenticationProvider customAuthenticationProvider() {
		CashPortalAuthenticationProvider impl = new CashPortalAuthenticationProvider();
		return impl;
	}

	@Bean
	public CashPortalUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter()
			throws Exception {
		CashPortalUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = new CashPortalUsernamePasswordAuthenticationFilter();
		customUsernamePasswordAuthenticationFilter.setAuthenticationManager(super.authenticationManagerBean());
		customUsernamePasswordAuthenticationFilter
				.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler());
		customUsernamePasswordAuthenticationFilter
				.setAuthenticationFailureHandler(customAuthenticationFailureHandler());
		return customUsernamePasswordAuthenticationFilter;
	}

	@Bean
	public CashPortalAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
		return new CashPortalAuthenticationSuccessHandler();
	}

	@Bean
	public CashPortalAuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CashPortalAuthenticationFailureHandler();
	}

	@Bean
	public CashPortalLogoutSuccessHandler customLogoutSuccessHandler() {
		return new CashPortalLogoutSuccessHandler();
	}


	@Bean
	public CashPortalAuthenticationEntryPoint customAuthenticationEntryPoint() {
		return new CashPortalAuthenticationEntryPoint();
	}

}