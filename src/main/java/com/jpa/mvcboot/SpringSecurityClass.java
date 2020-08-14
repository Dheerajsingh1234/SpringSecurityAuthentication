package com.jpa.mvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringSecurityClass extends WebSecurityConfigurerAdapter {
	@Autowired
	//UserDetailsService userDetailsService;
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 {
			 auth.authenticationProvider(authenticationProvider());
			
			 	
	 }
	 @Bean
	 public PasswordEncoder getPaas()
	 {
		 return NoOpPasswordEncoder.getInstance();
	 }
	 @Override
	 public void configure(HttpSecurity http) throws Exception
	 {
		 http
		 		.authorizeRequests()
		 		.antMatchers("/admin").hasRole("ADMIN")
		 		.antMatchers("/user").hasRole("USER")
		 		.antMatchers("/test1").hasAuthority("ACCESS_TEST1")
		 		.antMatchers("/test2").hasAuthority("ACCESS_TEST2")
		 		.antMatchers("/").permitAll()
		 		.and()
		 		.formLogin().permitAll()
		 		          .loginPage("/login").permitAll()
		 		          .loginProcessingUrl("/login")
		 		          .defaultSuccessUrl("/hello", true)
		 		          //.failureUrl("/login.html?error=true")
		 		          .and()
		 		          .logout().permitAll()
		 		          .logoutUrl("/perform_logout")
		 		          .deleteCookies("JSESSIONID");
		 		        
		 				
				 
	 }
	 @Bean
	 DaoAuthenticationProvider authenticationProvider()
	 {
		 DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		 dao.setPasswordEncoder(getPaas());

		 dao.setUserDetailsService(this.userDetailsService());
		 return dao;
	 }
}