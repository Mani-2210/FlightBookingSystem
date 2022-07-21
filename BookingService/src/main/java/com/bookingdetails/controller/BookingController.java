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
import org.springframework.web.bind.annotation.RestController;

import com.bookingdetails.model.BookingDetails;
import com.bookingdetails.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody BookingDetails bookingDetails){
		service.add(bookingDetails);
		return ResponseEntity.ok("added");
	}
	@GetMapping("/find/{id}")
	public Optional<BookingDetails> get(@PathVariable int id) {
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
	public ResponseEntity<?> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok("deleted");
	}
}
