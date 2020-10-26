package com.simplelearn.jo.admin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.simplelearn.jo.admin.user.services.UserService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Order(3)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// .antMatchers("/reports/**").hasRole("USER")
		http.authorizeRequests()//
				.antMatchers("/products/**", "/users/**", "/profile/**")//
				.hasRole("ADMIN")//
				.antMatchers("/login", "/shop", "/register", "/store/shop/**", "/css/**")//
				.permitAll()//
				.anyRequest()//
				.authenticated()//
				.and()//
				.formLogin()//
				.loginPage("/login").defaultSuccessUrl("/", true)//
				.failureUrl("/login-error")//
				.and()//
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//
				.logoutSuccessUrl("/login");
		http.csrf().disable();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public RoleHierarchyVoter roleVoter() {
		return new RoleHierarchyVoter(roleHierarchy());
	}

	@Bean
	public RoleHierarchyImpl roleHierarchy() {
		String hierarchy = "ROLE_ADMIN > ROLE_USER\r\nROLE_USER > ROLE_ANONYMOUS";
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		roleHierarchy.setHierarchy(hierarchy);
		return roleHierarchy;
	}
}