package com.userdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookingController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<?>> getAllBookings(){
		List<?> bookingList=restTemplate.getForObject("http://localhost:8082/findAll", List.class);
		return ResponseEntity.ok(bookingList);
	}

}
