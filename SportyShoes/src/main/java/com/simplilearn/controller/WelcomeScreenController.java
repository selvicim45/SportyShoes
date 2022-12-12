package com.simplilearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeScreenController {

	 @GetMapping("/welcome")
	 public String welcome() {
		 
		 return "welcome";
	 }
	
}
