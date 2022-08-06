package com.flightdetails.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service 
public class UserSecurityDetailsService implements UserDetailsService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//com.userdetails.model.UserDetails user=repo.findByFirstName(username);
		com.flightdetails.model.UserDetails user=null;
		com.flightdetails.model.UserDetails[] users=restTemplate.getForObject("http://localhost:8081/user/findAll", com.flightdetails.model.UserDetails[].class);
		for(com.flightdetails.model.UserDetails u:users) {
			if(u.getFirstName().equals(username)) {
				user=u;
			}
		}
		String uname=user.getFirstName();
		String password=user.getPassword();
		if(user==null) {
			throw new UsernameNotFoundException("not found");
		}
		return new User(uname,password,new ArrayList<>());
	}

}
