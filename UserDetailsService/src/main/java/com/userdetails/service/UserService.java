package com.userdetails.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdetails.model.UserDetails;
import com.userdetails.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public void add(UserDetails userDetails) {
		repo.save(userDetails);
	}
	public UserDetails get(String email) {
		return repo.findByEmail(email);
	}
	public List<UserDetails> getAll(){
		return repo.findAll();
	}
	public void update(UserDetails userDetails) {
	UserDetails ud= repo.findByEmail(userDetails.getEmail());
	if(ud!=null) {
		repo.save(userDetails);
	}
	}
	public void delete(String email) {
		repo.deleteById(email);
	}
}
