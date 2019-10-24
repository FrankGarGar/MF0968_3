package com.example.appspringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	@Autowired
//	private ServicioUsuarioImpl servicioU;
//	@Autowired
//	private BCryptPasswordEncoder bcrypt;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		
//		auth.userDetailsService(servicioU).passwordEncoder(bcrypt);
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//		http.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//		.httpBasic();
		
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.anyRequest()
			.authenticated()
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
//		http
//        .authorizeRequests()
//            .antMatchers("/", "/home").permitAll()
//            .anyRequest().authenticated()
//            .and()
//        .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .and()
//        .logout()
//            .permitAll();
//		http
//        .authorizeRequests()
//	        .antMatchers("/resources/**").permitAll()
//	        .antMatchers("/admin/**").hasRole("ADMIN")
//	        .antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")
//	        .antMatchers("/login*").permitAll()
//	        .antMatchers("/home").permitAll()
//	        .anyRequest().authenticated()
//        .and()
//        .formLogin()
//	        .loginPage("/login")
//	        .defaultSuccessUrl("/home", true)
//	        .failureUrl("/login?error=true")
//	        .permitAll()
//	        .usernameParameter("username")
//	        .passwordParameter("password")
//		.and()
//			.logout()
//			.permitAll()
//			.logoutSuccessUrl("/login?logout");
	}
}
