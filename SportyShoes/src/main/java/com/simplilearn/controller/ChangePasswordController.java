package com.simplilearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.simplilearn.entity.Admin;
import com.simplilearn.service.ChangePasswordService;


//Controller for Change Password
@Controller
public class ChangePasswordController {
	
	//Autowired to the Service Layer
	@Autowired
	ChangePasswordService changePasswordService;

	
	//Display Change Password template
	@GetMapping("/changepassword")
	public String changePassword()
	{
		return "changepassword";
	}
	 
	//Display update password template and update password
	@PostMapping("/updatepassword")
	public String updatePassword( @ModelAttribute Admin admin)
	{     
		//get the password entered in form using @ModelAttribute
		String pwd= admin.getAdmin_pwd();	
		
		//Retrieve the old password from database using getbyid method of CrudRepository
	    Admin adminToUpdate = changePasswordService.getById();	
	    
	    //Set New password to the old password
	    adminToUpdate.setAdmin_pwd(pwd);
	    
	   // Call the updatePassword method from service layer
		changePasswordService.updatePassword(admin);   
		    
		return "passwordchanged";
	}
}
