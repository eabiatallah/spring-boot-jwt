package com.eaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eaa.model.DAOUser;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Long>{
	
	DAOUser findByUsername(String username);

}
