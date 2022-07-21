package com.bookingdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingdetails.model.BookingDetails;

public interface BookingRepository extends JpaRepository<BookingDetails, Integer> {

}
