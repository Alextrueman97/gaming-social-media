package com.ab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements MyUserDetailsService {

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(UserData user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkIfUserExist(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
