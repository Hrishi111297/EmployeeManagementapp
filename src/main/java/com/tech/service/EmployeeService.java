package com.tech.service;

import java.util.List;

import com.tech.payloads.EmployeeDto;

public interface EmployeeService {
public EmployeeDto addEmployee(EmployeeDto e);
public EmployeeDto updateEmployee(EmployeeDto e,Integer eid);
public void deleteEmployee(Integer eid);
public EmployeeDto getPerticularEmployee(Integer eid);
public List<EmployeeDto>getAllEmployee();


}
