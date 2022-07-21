package com.flightdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightdetails.model.FlightDetails;
import com.flightdetails.repository.FlightRepository;

@Service
public class FlightService {
@Autowired
private FlightRepository repo;

public void add(FlightDetails flightDetails) {
	repo.save(flightDetails);
}
public void update(FlightDetails flightDetails) {
	repo.save(flightDetails);
}
public FlightDetails get(String flightName) {
	return repo.findByFlightName(flightName);
}
public List<FlightDetails> getAllFlights(){
	return repo.findAll();
}
public void delete(int id) {
	repo.deleteById(id);
}
}
