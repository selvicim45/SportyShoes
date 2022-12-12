package com.simplilearn.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplilearn.entity.User;
import com.simplilearn.repository.UserRepository;
import com.simplilearn.service.UserService;

@Controller
public class SearchUsersController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;	
	
	@GetMapping("/searchusers")
	public List<User> getAllUsers()
	{
		return userService.getUsers();
	}
    
    @GetMapping("/searchsignedupusers")
    public Collection<User> findAllSignedUpUsers()
    {
    	return userRepository.findAllSignedUpUsers("yes");
		
    }
}
