package com.tech.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	
		private int eid;
		@NotNull
	    @Size(max=100, message="Please enter a valid name")
	    private String name;

	    @Email(message="Please enter a valid email address")
	    private String email;

	    @Pattern(regexp="^\\+?[0-9. ()-]{7,25}$", message="Please enter a valid contact number")
	    private String contact;

	    @NotNull
	    @Size(min=4, max=50, message="Username must be between 4 and 50 characters")
	    private String username;

	    @NotNull
	    @Size(min=8, message="Password must be at least 8 characters long")
	    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message="Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character")
	    private String password;
	    
}
