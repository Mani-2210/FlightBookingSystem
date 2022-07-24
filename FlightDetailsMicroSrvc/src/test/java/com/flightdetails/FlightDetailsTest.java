package com.flightdetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

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
	details.setFlightName("Indigo");
	details.setDestination("mumbai");
	details.setStartsFrom("hyd");
	service.add(details);
	FlightDetails test_details=service.get(details.getId());
    assertNotNull(test_details);
	
}
@Test
public void get() {
	FlightDetails details=new FlightDetails();
	details.setFlightName("Indigo");
	details.setDestination("mumbai");
	details.setStartsFrom("hyd");
	service.add(details);
	
	FlightDetails detailss=service.get(details.getId());
	assertEquals("Indigo",details.getFlightName());
	
}
@Test
public void getAll() {
	List<FlightDetails> flightList=service.getAllFlights();
	assertNotEquals(0, flightList.size());
}
@Test
public void delete() {
	FlightDetails fd1=new FlightDetails();
	fd1.setFlightName("Air India");
	fd1.setStartsFrom("cochin");
	fd1.setDestination("mumbai");
	service.add(fd1);
	service.delete(fd1.getId());
	//assertNull(service.get(fd1.getId()));
}
@Test
public void updateTest() {
	
	FlightDetails fd1=new FlightDetails();
	fd1.setFlightName("SpiceJet");
	fd1.setStartsFrom("cochin");
	fd1.setDestination("mumbai");
	service.add(fd1);
	fd1.setStartsFrom("goa");
	service.update(fd1);
	assertEquals("goa", fd1.getStartsFrom());
	
}
}

