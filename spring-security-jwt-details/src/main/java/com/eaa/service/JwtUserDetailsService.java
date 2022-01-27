package com.eaa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eaa.model.DAOUser;
import com.eaa.model.UserDTO;
import com.eaa.repository.UserDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDTO loadUserByUsername(String username) throws UsernameNotFoundException {

		List<SimpleGrantedAuthority> roles = null;
		DAOUser user = userDao.findByUsername(username);

		if (user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			//return new User(user.getUsername(), user.getPassword(), roles);
			return new UserDTO( user.getUsername(), user.getEmail(), user.getPassword(), roles);
		} else
			throw new UsernameNotFoundException("User not found with username: " + username);

	}

	public DAOUser save(DAOUser user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		newUser.setEmail(user.getEmail());
		return userDao.save(newUser);
	}

}
