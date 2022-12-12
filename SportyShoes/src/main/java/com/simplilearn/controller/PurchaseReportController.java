package com.simplilearn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplilearn.entity.PurchaseReport;
import com.simplilearn.repository.PurchaseReportRepository;
import com.simplilearn.service.PurchaseReportService;

//Purchase Report Controller
@Controller
public class PurchaseReportController {
	@Autowired
	PurchaseReportService purchaseReportService;
	@Autowired
	PurchaseReportRepository purchaseReportRepository;
	
	
	
	@GetMapping("/purchasereport")
	   private String listProducts(Model model){
	      model.addAttribute("purchasereport", purchaseReportService.getPurchaseReport());
	      return "purchasereport";
	  	}


	@PostMapping("/purchasereport")
	public String purchaseByReport(@Validated String pdatedropdown,@Validated String categorydropdown, Model model) throws ParseException {
	    
		
			//Using @Validated annotation receives selected date or category from template
			
			
			if (pdatedropdown!="")
			{
				
				Date date = null;
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			    date = formatter.parse(pdatedropdown);
			    List<PurchaseReport> purchaseReportDate= purchaseReportRepository.findReportByDate(date);
			    model.addAttribute("purchasereport",purchaseReportDate);
			}
					
			else if ((categorydropdown!=""))
			{
				 
			      List<PurchaseReport> purchaseReportCategory= purchaseReportRepository.findReporyByCategory(categorydropdown);
			      model.addAttribute("purchasereport",purchaseReportCategory);
			}
			else
			{
				model.addAttribute("message", "Please Select Date/Category");
			}
			
			 return "purchasereportbydate";
		
	  
	}
	
}
