package com.tech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tech.security.EntryPoint;
import com.tech.security.JwtFiltetr;

@Configuration
@EnableWebMvc
public class SecurityConfig {

	public static final String[] URL_CONST= {"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**","/auth/login"};
    @Autowired
    private EntryPoint point;
    @Autowired
    private JwtFiltetr filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).cors(cors->cors.disable())
           .authorizeHttpRequests(auth->auth.	   
        		   requestMatchers(URL_CONST).permitAll().anyRequest().authenticated()).
               exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}