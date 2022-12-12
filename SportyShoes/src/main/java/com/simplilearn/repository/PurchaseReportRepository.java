package com.simplilearn.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.simplilearn.entity.PurchaseReport;


public interface PurchaseReportRepository extends CrudRepository<PurchaseReport, Integer>{
	
	@Query(value="select p.* from purchasereport p where p.pdate=?1",nativeQuery=true)
	List<PurchaseReport> findReportByDate(Date date1);
	
	@Query(value="select p.* from purchasereport p where p.category=?1",nativeQuery=true)
	List<PurchaseReport> findReporyByCategory(String category);

}
