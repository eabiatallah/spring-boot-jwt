package com.eaa.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eaa.userservice.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Role findByName(String name);

}
