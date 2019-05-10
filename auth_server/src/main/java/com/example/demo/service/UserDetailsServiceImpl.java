package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.AuthUserDetail;
import com.example.demo.model.User;
import com.example.demo.repository.UserDetailRepository;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailRepository userDetailRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = this.userDetailRepository.findByUsername(username);
		optionalUser.orElseThrow(()-> new UsernameNotFoundException("User or password wrong"));
		UserDetails userDetails = new AuthUserDetail(optionalUser.get());
		
		new AccountStatusUserDetailsChecker().check(userDetails);
		
		return userDetails;
	} 

}
