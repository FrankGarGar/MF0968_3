package com.example.appspringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
    public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/user**").access("hasRole('USER') or hasRole('ADMIN')")
			.antMatchers("/admin**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
        .formLogin()
          	.loginPage("/login")
          	.usernameParameter("username")
	        .passwordParameter("password")
	        .successHandler(authenticationSuccessHandler)
          	.failureUrl("/login?error=true")
          	.permitAll()
          	.and()
      	.logout()
      		.permitAll();
	
	}
	
}
