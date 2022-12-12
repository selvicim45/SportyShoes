package com.simplilearn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.simplilearn.entity.Admin;
import com.simplilearn.repository.ChangePasswordRepository;


@Service
public class ChangePasswordService {
	
	@Autowired
	ChangePasswordRepository changePasswordRepository;
	
	
	public void updatePassword(@ModelAttribute Admin admin)
	{
			changePasswordRepository.save(admin);										
					
	}
	
	public Admin getById()
	{
		Admin admin = new Admin();
		changePasswordRepository.findById(admin.getAdmin_id());
		return admin;
	}

}
