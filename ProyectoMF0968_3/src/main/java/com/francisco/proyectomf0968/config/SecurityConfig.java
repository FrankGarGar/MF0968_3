package com.francisco.proyectomf0968.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
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
			.antMatchers("/").access("hasRole('USER') or hasRole('ADMIN')")
			.antMatchers("/home").access("hasRole('USER') or hasRole('ADMIN')")
			.antMatchers("/listado-productos").access("hasRole('USER') or hasRole('ADMIN')")
			.anyRequest().hasRole("ADMIN")
	
			.and()
        .formLogin()
          	.loginPage("/login")
          	.usernameParameter("username")
	        .passwordParameter("password")
          	.failureUrl("/login?error=true")
          	.permitAll()
          	.and()
      	.logout()
      		.permitAll();
	
	}
	
}
