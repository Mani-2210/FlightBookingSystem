package com.flightdetails.controller;

public class FlightNameException extends RuntimeException{
	public FlightNameException() {
		super("Invalid Flight Name");
	}

	@Override
	public String toString() {
		return "Invalid Flight Name";
	}
	

}
