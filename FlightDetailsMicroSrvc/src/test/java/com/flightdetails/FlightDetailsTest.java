package com.flightdetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightdetails.model.FlightDetails;
import com.flightdetails.service.FlightService;

@SpringBootTest
public class FlightDetailsTest {
	
	@Autowired
	FlightService service;
	
@Test
public void testAdd() {
	FlightDetails details=new FlightDetails();
	details.setFlightName("flight-102");
	details.setId(3);
	details.setDestination("mumbai");
	details.setStartsFrom("hyd");
	service.add(details);
	FlightDetails test_details=service.get(details.getFlightName());
    assertNotNull(test_details);
	
}
@Test
public void get() {
	FlightDetails details=service.get("flight-102");
	assertEquals("flight-102",details.getFlightName());
	
}
@Test
public void getAll() {
	List<FlightDetails> flightList=service.getAllFlights();
	assertEquals("flight-102",flightList.get(2).getFlightName());
	assertEquals("Boeing-323", flightList.get(1).getFlightName());
}
@Test
public void delete() {
	FlightDetails fd1=new FlightDetails();
	fd1.setFlightName("boeing-123");
	fd1.setId(4);
	fd1.setStartsFrom("cochin");
	fd1.setDestination("mumbai");
	service.add(fd1);
	service.delete(4);
	FlightDetails fd=service.get("Boeing-325");
	assertNull(fd);
}
@Test
public void updateTest() {
	
}
}

