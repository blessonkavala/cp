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
 * This class currently configures the implementation of BasicAuthentication.
 * TODO:Will be enhanced to DAO based authentication in future sprints
 * 
 * @author Sam Sundar K
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		// TODO:CHECK LATER
		http.formLogin()
			.loginPage("/login.html")
			.failureUrl("/login.html?error")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessHandler(customLogoutSuccessHandler())
			.logoutUrl("/login.html?logout")
			.permitAll()
		.and()
			.headers()
			.contentTypeOptions()
			.disable()
		.and()
			.authorizeRequests()
			.antMatchers("/*.js", "/*.css", "/*.html", "/fonts/**", "/img/**","/css/**","/bower_components/**","/app/**")
			.permitAll()
		.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated()
		.and()
			.requestCache()
			.requestCache(new NullRequestCache())
		.and()
			.exceptionHandling()
			.authenticationEntryPoint(customAuthenticationEntryPoint())
		.and()
			.httpBasic()
			.disable()
			.addFilter(customUsernamePasswordAuthenticationFilter());
		
		http.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint());		
		
//		http.authorizeRequests().anyRequest().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.authenticationProvider(customAuthenticationProvider());
	}

	@Bean
	public AuthenticationProvider customAuthenticationProvider() {
		CustomAuthenticationProvider impl = new CustomAuthenticationProvider();
		// impl.setUserDetailsService(customUserDetailsService());
		/* other properties etc */
		return impl;
	}

	@Bean
	public CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter() throws Exception {
		CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = new CustomUsernamePasswordAuthenticationFilter();
		customUsernamePasswordAuthenticationFilter.setAuthenticationManager(super.authenticationManagerBean());
		customUsernamePasswordAuthenticationFilter
				.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler());
		customUsernamePasswordAuthenticationFilter
				.setAuthenticationFailureHandler(customAuthenticationFailureHandler());
		return customUsernamePasswordAuthenticationFilter;
	}

	@Bean
	public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
		return new CustomAuthenticationSuccessHandler();
	}

	@Bean
	public CustomAuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean
	public CustomLogoutSuccessHandler customLogoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}

	@Bean
	public LoginSuccessResponse loginSuccessResponse() {
		return new LoginSuccessResponse();
	}
	
	@Bean
	public CustomAuthenticationEntryPoint customAuthenticationEntryPoint()
	{
		return new CustomAuthenticationEntryPoint();
	}

}