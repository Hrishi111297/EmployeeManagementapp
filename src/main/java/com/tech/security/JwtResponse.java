package com.tech.security;

import com.tech.payloads.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class JwtResponse {
private String token;
private String username;
private EmployeeDto employeeData;

}
