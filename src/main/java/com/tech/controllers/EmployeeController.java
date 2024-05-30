package com.tech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.payloads.EmployeeDto;
import com.tech.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
@PostMapping("/addEmp")
public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto e){	
	return new ResponseEntity<EmployeeDto>(this.employeeService.addEmployee(e),HttpStatus.CREATED);
}
@GetMapping("/getAll")
public ResponseEntity<List<EmployeeDto>> getAllEmployee(){	
	return new ResponseEntity<List<EmployeeDto>>(this.employeeService.getAllEmployee(),HttpStatus.OK);
}
}
