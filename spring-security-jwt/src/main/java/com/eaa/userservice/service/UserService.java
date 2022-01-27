package com.eaa.userservice.service;

import java.util.List;

import com.eaa.userservice.model.Role;
import com.eaa.userservice.model.User;

public interface UserService {

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	User getUser(String username);

	List<User> getUsers();

}
