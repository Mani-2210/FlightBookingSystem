package com.flightdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flightdetails.model.FlightDetails;

public interface FlightRepository extends MongoRepository<FlightDetails, Integer> {
FlightDetails findByFlightName(String name);
void deleteById(String flightName);

}
