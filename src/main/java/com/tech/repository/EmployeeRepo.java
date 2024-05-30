package com.tech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entities.Employee;

public interface EmployeeRepo  extends JpaRepository<Employee,Integer>{
	Optional<Employee> findByUsername(String Username);

}
