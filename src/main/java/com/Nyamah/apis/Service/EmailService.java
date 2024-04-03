package com.Nyamah.apis.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Nyamah.apis.entities.ContactUs;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired private JavaMailSender javaMailSender;
	


	public String sendMail(ContactUs contactus)
    {
 
        // Try block to check for exceptions
        try {
 
            // Creating a  mail message
//         
        	MimeMessage mailMessage = javaMailSender.createMimeMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(contactus.getEmail());
            
            mailMessage.setRecipients( MimeMessage.RecipientType.TO, InternetAddress.parse("info@nyamah.in"));
           
            
            
                String htmlContent = readHtmlFile("src\\main\\resources\\static\\form.html");
              
            
            
            
            

            
            htmlContent = htmlContent.replace("${name}", contactus.getName());
           htmlContent = htmlContent.replace("${email}", contactus.getEmail());
            htmlContent = htmlContent.replace("${mobnumber}", contactus.getMobileNumber());
           htmlContent = htmlContent.replace("${address}", contactus.getAddress());
           htmlContent = htmlContent.replace("${message}", contactus.getMessage());
         

           mailMessage.setContent(htmlContent, "text/html; charset=utf-8");
           mailMessage.setSubject(contactus.getSubject());
 
            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
        
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }


	
	public static String readHtmlFile(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        return new String(bytes);
    }
}
