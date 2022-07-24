package com.flightdetails.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flightdetails.model.FlightDetails;

public interface FlightRepository extends MongoRepository<FlightDetails, Integer> {
FlightDetails findById(String name);
void deleteById(String flightName);

}
