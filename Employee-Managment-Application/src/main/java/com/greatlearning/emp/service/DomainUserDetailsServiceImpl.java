package com.greatlearning.emp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.emp.repository.UserRepository;
import com.greatlearning.emp.model.DomainUserDetails;



@Service
public class DomainUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = this.userRepository
				.findByUsername(username)
				.map(DomainUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("invalid username"));

System.out.println("User:" + user.getUsername());
System.out.println("Roles:" + user.getAuthorities());
return user;
	}

}
