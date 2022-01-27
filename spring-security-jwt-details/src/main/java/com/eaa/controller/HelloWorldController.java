package com.eaa.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eaa.model.UserDTO;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String firstPage(Authentication auth) {

		UserDTO userDetails = (UserDTO) auth.getPrincipal();

		System.out.println("User has authorities: " + userDetails.getAuthorities());
		System.out.println("User has email: " + userDetails.getEmail());

		System.out.println("--- Secure User ----" + auth.getPrincipal());
		System.out.println("--- Secure Credentials ----" + auth.getCredentials());
		System.out.println("--- Secure Authorities ----" + auth.getAuthorities());
		System.out.println("--- Secure Details ----" + auth.getDetails());
		System.out.println("--- Secure Name ----" + auth.getName());
		return "Hello World !";
	}

}
