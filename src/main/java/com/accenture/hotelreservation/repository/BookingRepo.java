package com.accenture.hotelreservation.repository;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.accenture.hotelreservation.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {
	
	// used to find inactive bookings
	Set<Booking> findByEndDateLessThan(LocalDate today);

	// used to find active bookings
	Set<Booking> findByEndDateGreaterThanEqual(LocalDate today);
	
	
	
}
