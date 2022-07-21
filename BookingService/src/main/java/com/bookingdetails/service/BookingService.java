package com.bookingdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingdetails.model.BookingDetails;
import com.bookingdetails.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository repo;
	
	public void add(BookingDetails bookingDetails) {
		repo.save(bookingDetails);
	}
	public Optional<BookingDetails> get(int id) {
		return repo.findById(id);
	}

	public List<BookingDetails> getAll(){
		return repo.findAll();
	}
	public void update(BookingDetails bookingDetails) {
		Optional<BookingDetails> b=repo.findById(bookingDetails.getId());
		if(b!=null) {
			repo.save(bookingDetails);
		}
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
}
