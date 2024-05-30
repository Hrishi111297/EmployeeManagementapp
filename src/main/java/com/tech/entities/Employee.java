package com.tech.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee  implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	@Column(name = "employee_name", nullable = false, length = 100,unique = true)
	private String name;
	@Column(nullable = false, length = 100)
	private String email;
	@Column(nullable = false, length = 100)
	private String contact;
	@Column(nullable = false, length = 100)
	private String username;
	@Column(nullable = false, length = 200)
	private String password;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
