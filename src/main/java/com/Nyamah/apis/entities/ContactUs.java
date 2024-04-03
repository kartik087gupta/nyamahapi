package com.Nyamah.apis.entities;

import com.Nyamah.apis.CustomAnnotation.MobileNumber;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class ContactUs {

	@NotEmpty(message = "name cannot be empty")
	@Size(min=3, message="name must be atleast three characters")
	private String name;
	
	@NotEmpty(message = "Email cannot be empty")
	@Email(message="email is invalid", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	@NotEmpty(message="mobile no. cannot be empty")
	@Size(min=10,max=10, message="mobile no. must be 10 digits ")
	@MobileNumber
	private String mobileNumber ;
	@NotEmpty(message="address cannot be empty")
	private String address;
	@NotEmpty(message="subject cannot be empty")
	private String subject;
	@NotEmpty
	
	@Size(max=500,message="maximum input characters are 500")
	private String message;
	
	
	
}
