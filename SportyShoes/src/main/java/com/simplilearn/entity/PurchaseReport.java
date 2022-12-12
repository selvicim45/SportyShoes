package com.simplilearn.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="purchasereport")
public class PurchaseReport {

	@Id	
	@GeneratedValue
	@Column(name="pid")
	private int pid;
	
	@Column(name="pdate")
	private Date pdate;
	
	@Column(name="description")
	private String report;
	
	@Column(name="category")
	private String category;
	
	

	public PurchaseReport() {
		super();
		
	}



	public PurchaseReport(int pid, Date pdate, String report, String category) {
		super();
		this.pid = pid;
		this.pdate = pdate;
		this.report = report;
		this.category = category;
	}



	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public Date getPdate() {
		return pdate;
	}



	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}



	public String getReport() {
		return report;
	}



	public void setReport(String report) {
		this.report = report;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}

	
	
}
