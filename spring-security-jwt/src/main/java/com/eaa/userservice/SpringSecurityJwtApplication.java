package com.eaa.userservice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eaa.userservice.model.Role;
import com.eaa.userservice.model.User;
import com.eaa.userservice.service.UserService;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Elias", "eabiatallah", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "test", "test", "1234", new ArrayList<>()));

			userService.addRoleToUser("eabiatallah", "ROLE_USER");
			userService.addRoleToUser("eabiatallah", "ROLE_ADMIN");
			userService.addRoleToUser("test", "ROLE_MANAGER");

		};
	}

}
