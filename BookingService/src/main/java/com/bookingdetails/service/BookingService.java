package com.bookingdetails.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookingdetails.model.BookingDetails;
import com.bookingdetails.model.Login;
import com.bookingdetails.model.UserDetails;
import com.bookingdetails.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository repo;
	@Autowired
	private RestTemplate restTemplate;

	public boolean status=false;
	
	public ResponseEntity<?> add(BookingDetails bookingDetails,String flightId) {
		
		if(status==true) {
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String numbers = "012345678901234567890";
			
			String alphaNumeric = alphabet + numbers ;
			
			StringBuilder sb = new StringBuilder();
			
			Random random = new Random();
			
			int length = 5;
			for(int i = 0; i<length;i++) {
				int index = random.nextInt(alphaNumeric.length());
				
				char randomChar = alphaNumeric.charAt(index);
				
				sb.append(randomChar);
				
			}
			
			String ranString = sb.toString();
			
			bookingDetails.setId("B"+ranString);
		

		
		bookingDetails.setFlightName(flightId);
		repo.save(bookingDetails);
		status=false;
		return ResponseEntity.ok("booking successfull");
		
		}
		else {
			return ResponseEntity.ok("login for booking");
		}
	}
	public ResponseEntity<?> login(Login login) {
		UserDetails[] userDetails=restTemplate.getForObject("http://localhost:8081/findAll", UserDetails[].class);
		for(UserDetails u:userDetails) {
			if(u.getFirstName().equals(login.getUserName())&&u.getPassword().equals(login.getPassword())) {
				status=true;
			}
		}
		if(status==true) {
			return ResponseEntity.ok("logged in successfully");
			
		}
		else 
			return ResponseEntity.ok("please register before login");
		
		
	}
	public Optional<BookingDetails> get(String id) {
		
		
		return repo.findById(id);
	}

	public List<BookingDetails> getAll(){
		return repo.findAll();
	}
	public void update(BookingDetails bookingDetails) {
		Optional<BookingDetails> b=repo.findById(bookingDetails.getId());
		if(b!=null) {
			repo.save(bookingDetails);
		}
	}
	public void delete(String id) {
		repo.deleteById(id);
	}
}
