package com.flightdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightdetails.controller.AddFlightException;
import com.flightdetails.controller.FindFlightException;
import com.flightdetails.controller.FlightNameException;
import com.flightdetails.model.FlightDetails;
import com.flightdetails.repository.FlightRepository;

@Service
public class FlightService {
@Autowired
private FlightRepository repo;

public void add(FlightDetails flightDetails) throws FlightNameException {
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String numbers = "012345678901234567890";
	
	String alphaNumeric = alphabet + numbers ;
	
	StringBuilder sb = new StringBuilder();
	
	Random random = new Random();
	
	int length = 4;
	for(int i = 0; i<length;i++) {
		int index = random.nextInt(alphaNumeric.length());
		
		char randomChar = alphaNumeric.charAt(index);
		
		sb.append(randomChar);
		
	}
	
	String ranString = sb.toString();
	flightDetails.setId(ranString);
	//Flight Name check
	ArrayList flightNames=new ArrayList<>();
	flightNames.add("Indigo");
	flightNames.add("Air India");
	flightNames.add("SpiceJet");
	flightNames.add("Go First");
	flightNames.add("AirAsia India");
	flightNames.add("Vistara");
	flightNames.add("TruJet");
	flightNames.add("Alliance Air");
	
	if(flightNames.contains(flightDetails.getFlightName())) {
	repo.save(flightDetails);
	}
	else 
		throw new AddFlightException();
}
public void update(FlightDetails flightDetails) {
	repo.save(flightDetails);
}
public FlightDetails get(String id) throws FindFlightException {
	
	FlightDetails f= repo.findById(id);
	if(f==null) {
		throw new FindFlightException();
	}
	return f;
}
public List<FlightDetails> getAllFlights(){
	return repo.findAll();
}
public void delete(String id) {
	repo.deleteById(id);
}
}
