package com.accenture.hotelreservation.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.hotelreservation.model.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {

	Set<Room> findByBookingsIsNull();

	Set<Room> findByBookingsIsNullOrBookings_startDateGreaterThanEqualOrBookings_endDateLessThanEqual(LocalDate queryEndDate,
			LocalDate queryStartdate);

}
