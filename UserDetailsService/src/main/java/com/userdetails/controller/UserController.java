package com.userdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userdetails.model.AuthenticationRequest;
import com.userdetails.model.AuthenticationResponse;
import com.userdetails.model.UserDetails;
import com.userdetails.service.UserSecurityDetailsService;
import com.userdetails.service.UserService;

@RestController
public class UserController {
@Autowired
private UserService service;
@Autowired
private AuthenticationManager authManager;
@Autowired
private UserSecurityDetailsService userDetailsService;
@Autowired
private com.userdetails.service.JwtUtil jwtTokenUtil;

@RequestMapping("/")
public String hello() {
	return "Welcome to flight Booking application";
}

@PostMapping("/add")
public ResponseEntity<?> add(@RequestBody UserDetails userDetails){
	service.add(userDetails);
	return ResponseEntity.ok("added");
}
@GetMapping("/find/{email}")
public UserDetails find(@PathVariable String email) {
	return service.get(email);
}
@GetMapping("/findAll") 
public List<UserDetails> getAll(){
	return service.getAll();
}
@PatchMapping("/update")
public ResponseEntity<?> update(@RequestBody UserDetails userDetails){
	service.update(userDetails);
	return ResponseEntity.ok("updated");
}
@DeleteMapping("/delete/{email}")
public ResponseEntity<?> deleteUser(@PathVariable String email){
	service.delete(email);
	return ResponseEntity.ok("deleted");
}
@RequestMapping(value="/authenticate",method=RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)throws Exception{
	try {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
	}
	catch(BadCredentialsException e) {
		throw new Exception("Incorrect UserName");
	}
	final org.springframework.security.core.userdetails.UserDetails userDetails=userDetailsService.loadUserByUsername(authRequest.getUsername());
	final String jwt=jwtTokenUtil.generateToken(userDetails);
	
	return ResponseEntity.ok(new AuthenticationResponse(jwt));
}
}
