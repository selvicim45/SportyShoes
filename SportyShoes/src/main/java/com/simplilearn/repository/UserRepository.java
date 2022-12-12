package com.simplilearn.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer> {

	@Query(value="select u.* from user u where u.signedup=?1",nativeQuery = true)
	Collection<User> findAllSignedUpUsers(String signedup);
}


