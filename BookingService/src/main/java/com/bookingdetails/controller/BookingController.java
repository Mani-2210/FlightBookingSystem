package com.bookingdetails.controller;

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
import org.springframework.web.client.RestTemplate;

import com.bookingdetails.model.BookingDetails;
import com.bookingdetails.model.FlightDetails;
import com.bookingdetails.model.Login;
import com.bookingdetails.model.ResponseClass;
import com.bookingdetails.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addbooking/{flightId}")
	public ResponseEntity<?> add(@RequestBody BookingDetails bookingDetails,@PathVariable String flightId){
		return service.add(bookingDetails,flightId);
	}
	@GetMapping("/find/{id}")
	public Optional<BookingDetails> get(@PathVariable String id) {
		return service.get(id);
	}
	@GetMapping("/findAll")
	public List<BookingDetails> getAll(){
		return service.getAll();
	}
	@PatchMapping("/update")
	public ResponseEntity<?> udpate(@RequestBody BookingDetails bookingDetails){
		service.update(bookingDetails);
		return ResponseEntity.ok("updated");
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.ok("deleted");
	}
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login){
		
		return service.login(login);
	
	}
	@RequestMapping("/getBookingDetails/{id}")
	public ResponseEntity<?> getBookingDetails(@PathVariable String id){
		
		FlightDetails[] flights=restTemplate.getForObject("http://localhost:8080/flight/findAll",FlightDetails[].class);
		Optional<BookingDetails> booking=service.get(id);
		ResponseClass response=new ResponseClass();
		
		for(FlightDetails f:flights) {
			if(booking.get().getFlightName().equals(f.getId())) {
				response.setFrom(f.getStartsFrom());
				response.setTo(f.getDestination());
				response.setPassName(booking.get().getFirstName());
				response.setFlightName(f.getFlightName());
			}
		}
		if(response!=null) {
			return ResponseEntity.ok(response);
		}
		else
			return ResponseEntity.ok("booking not found");
		
		
	}
}
