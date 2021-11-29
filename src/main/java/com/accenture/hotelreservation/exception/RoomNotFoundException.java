package com.accenture.hotelreservation.exception;

public class RoomNotFoundException extends RuntimeException{
	
	public RoomNotFoundException(long id) {
		super("Room not found with id " + id);
	}

}
