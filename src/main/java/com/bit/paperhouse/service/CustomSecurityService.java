package com.bit.paperhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.paperhouse.dao.UserRepository;
import com.bit.paperhouse.model.CustomSecurityDetails;

@Service
public class CustomSecurityService implements UserDetailsService {
	
	@Autowired
	private UserRepository dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      
		System.out.println("CustomUserService loadUserByUsername");
		
		CustomSecurityDetails user =  dao.findByid(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}		
		return user;
	}

}
