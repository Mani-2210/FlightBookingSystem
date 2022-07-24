package com.flightdetails.controller;


public class AddFlightException extends RuntimeException{
	
	public AddFlightException() {
		super("please fill all the details required");
	}

	@Override
	public String toString() {
		return "please fill all the details required";
	}
	

}
