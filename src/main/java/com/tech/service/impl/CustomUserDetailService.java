package com.tech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tech.entities.Employee;
import com.tech.exceptions.ResourceNotFound;
import com.tech.repository.EmployeeRepo;
@Service
public class CustomUserDetailService  implements UserDetailsService{
@Autowired
EmployeeRepo employeeRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee Emp=this.employeeRepo.findByUsername(username).orElseThrow( ()->new ResourceNotFound("Employee", "username", username));
		return Emp;
	}

}
