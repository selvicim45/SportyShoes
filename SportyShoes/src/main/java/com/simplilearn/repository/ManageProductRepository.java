package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Product;

@Repository
public interface ManageProductRepository extends CrudRepository<Product,Integer>{

}
 