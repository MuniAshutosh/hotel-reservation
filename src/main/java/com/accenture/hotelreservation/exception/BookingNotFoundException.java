package com.accenture.hotelreservation.exception;

public class BookingNotFoundException extends RuntimeException{
	
	public BookingNotFoundException(long id) {
		super("Booking not found with id " + id);
	}

}
