package com.simplilearn.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


import com.simplilearn.entity.Product;

import com.simplilearn.repository.ManageProductRepository;
import com.simplilearn.service.ProductService;


//Manage Products Controller
@Controller
public class ManageProductsController {

//Autowired the Service Layer dependency
@Autowired
private ProductService productService;

//Autowired the Repository Layer dependency
@Autowired
private ManageProductRepository mrp;
  
   // to display data from database when the manageproducts template opens
   @GetMapping("/manageproducts")
    public List<Product> getAllProducts()
     {	  
			return productService.listAll();
	 }
	    
	   
 //Method opens the template to add a edit product
	@GetMapping("/edit{id}")
	public String editForm(@PathVariable("id") int id, Model model)
	{				
		
		 //Using @Pathvariable id in form, calls the findById method of CrudRepository
	      Optional<Product>  product = this.mrp.findById(id);
	      Product productToDisplay = new Product();
	      
	      //Check whether the Id present in database
	      if (product.isPresent())	      {
            
	    	  //If present retrieves the data
	    	 productToDisplay = product.get();		
	    	 //Using model attribute display in template
	         model.addAttribute("product", productToDisplay);          
             
	      }      	 
       
	      return "edit";
	}
	
	
	//To Edit the product
	@GetMapping("/update")
	public String updateProduct(@Validated Product product, BindingResult result, Model model)
	{
		
	
		//Update product
		productService.save(product);
		
		//Get all students with update
		model.addAttribute("product",this.productService.listAll());
		return "redirect:manageproducts";
	}

	//Retrieves selected product from database using the @PathVariable
	@GetMapping("delete{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model )
	{
		
		this.productService.deleteProduct(id);
		model.addAttribute("product", this.productService.listAll());
		return "redirect:manageproducts";		
	}
		
    
	
	
	//Method opens the template to add a product
	@GetMapping("/add")
	public String add()
	{
		return "add";
	}
	
	//Method invoke when add button clicked inside add template
	//to store value in database
	@GetMapping("/addproduct")
	public String  add(@Validated Product product, BindingResult result, Model model)
	{
		if (result.hasErrors())
		{
			return "add";
		}
		this.productService.save(product);
		return "addedsuccessfully";
	}
	    
}
