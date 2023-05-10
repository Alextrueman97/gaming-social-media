package com.ab.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ab.entities.UserData;
import com.ab.exceptions.UserAlreadyExistsException;

public interface MyUserDetailsService extends UserDetailsService {
	
	public void register(UserData user) throws UserAlreadyExistsException;
	public boolean checkIfUserExist(String username);
	

}