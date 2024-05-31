package com.tech.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tech.entities.Employee;
import com.tech.payloads.EmployeeDto;
import com.tech.repository.EmployeeRepo;
import com.tech.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public EmployeeDto addEmployee(EmployeeDto e) throws DataIntegrityViolationException {
		Employee emp = this.modelMapper.map(e, Employee.class);
		return this.modelMapper.map(this.employeeRepo.save(emp), EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto e, Integer eid) {

		return null;
	}

	@Override
	public void deleteEmployee(Integer eid) {

	}

	@Override
	public EmployeeDto getPerticularEmployee(Integer eid) {

		return null;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		return this.employeeRepo.findAll().stream().map(emp->this.modelMapper.map(emp,EmployeeDto.class)).collect(Collectors.toList());
	}

}
