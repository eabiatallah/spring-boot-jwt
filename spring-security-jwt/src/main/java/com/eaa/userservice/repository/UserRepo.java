package com.eaa.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eaa.userservice.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
