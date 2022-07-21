package com.flightdetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightdetails.model.FlightDetails;
import com.flightdetails.service.FlightService;

@RestController
public class FlightController {
	@Autowired
	private FlightService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addFlight(@RequestBody FlightDetails flightDetails){
		service.add(flightDetails);
		return ResponseEntity.ok("added");
	}
	@GetMapping("/find/{name}")
	public FlightDetails findFlight(@PathVariable String name) {
		return service.get(name);
	}
	@GetMapping("/findAll")
	public List<FlightDetails> findAllFlights(){
		return service.getAllFlights();
	}
	@PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody FlightDetails flightDetails){
    	service.update(flightDetails);
    	return ResponseEntity.ok("updated");
    	}
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<?> delete(@PathVariable int name){
		service.delete(name);
		return ResponseEntity.ok("deleted");
	}
}

