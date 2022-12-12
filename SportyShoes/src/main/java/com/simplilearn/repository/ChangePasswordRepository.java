package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Admin;

@Repository
public interface ChangePasswordRepository extends  CrudRepository<Admin,Integer> {

}
