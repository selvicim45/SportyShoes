package com.simplilearn.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.simplilearn.entity.User;
import com.simplilearn.repository.UserRepository;




@Service
public class UserService {
	
    @Autowired
    UserRepository userRepository;
    
    
    public List<User> getUsers(){
        	
    	
    List<User> user = new ArrayList<>();
    userRepository.findAll().forEach(u -> user.add(u));
    return user;

    }
    
    
}

