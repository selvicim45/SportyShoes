package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.PurchaseReport;

import com.simplilearn.repository.PurchaseReportRepository;

@Service
public class PurchaseReportService {
	
	@Autowired
	PurchaseReportRepository purchaseReportRepository;
	
	 public List<PurchaseReport> getPurchaseReport(){
     	
	    	
		    List<PurchaseReport> purchasereport = new ArrayList<>();
		    purchaseReportRepository.findAll().forEach(p -> purchasereport.add(p));
		    
		    return purchasereport;

		    }
}
	
