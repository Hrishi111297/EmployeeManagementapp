package com.tech;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeemanagementAppApplication implements CommandLineRunner {
@Autowired
BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementAppApplication.class, args);
	}
@Bean
public ModelMapper modelMapper() {
	return new ModelMapper();
}
@Override
public void run(String... args) throws Exception {
	System.out.println(bCryptPasswordEncoder.encode("hrishi"));
	
}
}
