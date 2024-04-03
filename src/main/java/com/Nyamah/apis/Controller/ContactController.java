package com.Nyamah.apis.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Nyamah.apis.Service.EmailService;
import com.Nyamah.apis.entities.ContactUs;
import com.Nyamah.apis.payload.ApiResponse;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contactus")
public class ContactController {

	
	@Autowired
	private EmailService emailservice;
	

	
	@PostMapping("/submit")
	public  ResponseEntity<?> createContact(@Valid @RequestBody(required = false) ContactUs contactUs) {
		
		try {
			if (contactUs == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT)
						.body(new ApiResponse("error", "fields cannot be null",null));
			}
		
		  this.emailservice.sendMail(contactUs);
		
		return  new ResponseEntity<ApiResponse>(new ApiResponse("success" ,"Message Sent Successfully",contactUs), HttpStatus.OK);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("error", "error occured: " + e.getMessage().replace("\"", ""),null));
		}
	}
	


	
	
	 
	   

}