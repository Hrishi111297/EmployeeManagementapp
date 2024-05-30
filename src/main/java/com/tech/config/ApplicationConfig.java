package com.tech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tech.service.impl.CustomUserDetailService;
@Configuration

public class ApplicationConfig {
//	@Bean
//	public UserDetailsService userDetailService() {
//		UserDetails ayush = User.builder().username("HM1594").password(bCryptPasswordEncoder().encode("abc")).roles("ADMIN")
//				.build();
//		UserDetails hrishi = User.builder().username("hrishi").password(bCryptPasswordEncoder().encode("abc")).roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(ayush, hrishi);
//	} 
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	        return builder.getAuthenticationManager();
	    }
	 
	 
	 @Autowired
CustomUserDetailService customUserDetailService;
	 //for the database authentication
	 @Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
		daoAuthenticationProvider.setPasswordEncoder(this.bCryptPasswordEncoder());
		return daoAuthenticationProvider;
	}

}
