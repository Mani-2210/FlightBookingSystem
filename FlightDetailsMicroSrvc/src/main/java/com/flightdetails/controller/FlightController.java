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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightdetails.model.FlightDetails;
import com.flightdetails.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addFlight(@RequestBody FlightDetails flightDetails)throws AddFlightException {
		
		 service.add(flightDetails);
		return ResponseEntity.ok("added");
	}
	@GetMapping("/find/{name}")
	public FlightDetails findFlight(@PathVariable String name) throws FindFlightException{
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
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		FlightDetails f=service.get(id);
		if(f==null) {
			throw new DeleteFlightException();
		}
		service.delete(id);
		return ResponseEntity.ok("deleted");
	}
}

