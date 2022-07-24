package com.userdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FlightController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getallflights")
	public ResponseEntity<?> getFlight(){
		List<?> flightList=restTemplate.getForObject("http://localhost:8080/findAll",List.class);
		return ResponseEntity.ok(flightList);
	}
}
