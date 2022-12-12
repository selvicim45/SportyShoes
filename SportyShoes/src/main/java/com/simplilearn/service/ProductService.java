package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simplilearn.entity.Product;
import com.simplilearn.repository.ManageProductRepository;

@Service
public class ProductService {

	@Autowired
	private ManageProductRepository manageProductRepository;
	
	//Method to List all Products from DB
	public List<Product> listAll(){		
		List<Product> product = new ArrayList<>();
		manageProductRepository.findAll().forEach(p -> product.add(p));
	    return product;
	}
	
	//Method to delete from DB
	 public void deleteProduct(int id)
	 {		 
			manageProductRepository.deleteById(id);
	 }
	 
		 
	 
	 public void save(Product product)
	 {
		 manageProductRepository.save(product);
	 }
}
