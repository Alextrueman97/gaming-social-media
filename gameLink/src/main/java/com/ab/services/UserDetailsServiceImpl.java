package com.ab.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ab.entities.MyUserDetails;
import com.ab.entities.UserAccount;
import com.ab.entities.UserData;
import com.ab.exceptions.UserAlreadyExistsException;
import com.ab.repositories.UserAccountRepository;

@Service
public class UserDetailsServiceImpl implements MyUserDetailsService {

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserAccount user = userAccountRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyUserDetails(user);
	}

	@Override
	public void register(UserData user) throws UserAlreadyExistsException {
		
		if (checkIfUserExist(user.getUsername())) {
			throw new UserAlreadyExistsException("User already exists for this username");
		}
		
		UserAccount userEntity = new UserAccount();
		BeanUtils.copyProperties(user, userEntity);
		encodePassword(userEntity, user);
		
		userAccountRepository.save(userEntity);
		
	}

	@Override
	public boolean checkIfUserExist(String username) {

		return userAccountRepository.findByUsername(username) != null ? true : false;
		
	}
	
	private void encodePassword(UserAccount userEntity, UserData user) {
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
	}
	
	
}
