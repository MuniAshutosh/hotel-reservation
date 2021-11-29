package com.accenture.hotelreservation.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.hotelreservation.exception.BookingNotFoundException;
import com.accenture.hotelreservation.exception.RoomNotFoundException;
import com.accenture.hotelreservation.model.Booking;
import com.accenture.hotelreservation.model.Guest;
import com.accenture.hotelreservation.model.Room;
import com.accenture.hotelreservation.model.types.Response;
import com.accenture.hotelreservation.repository.BookingRepo;
import com.accenture.hotelreservation.repository.RoomRepo;

@RestController
@RequestMapping(path = "/booking")
public class BookingController {

	@Autowired
	private BookingRepo bookingRepo;

	@Autowired
	private RoomRepo roomRepo;

	@GetMapping("/test")
	public String test() {
		return "OK";
	}

	@GetMapping("/{startDate}/{endDate}")
	Set<Room> availableRooms(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
		Set<Room> unbookedRooms = roomRepo
				.findByBookingsIsNullOrBookings_startDateGreaterThanEqualOrBookings_endDateLessThanEqual(endDate,
						startDate);
		return unbookedRooms;

	}

	@PostMapping("/")
	Booking bookRoom(@RequestBody Booking booking) {
		return bookingRepo.save(booking);
	}

	@DeleteMapping("/{bookingId}")
	void deleteBooking(@PathVariable Long bookingId) {
		bookingRepo.deleteById(bookingId);
	}

	@GetMapping("/")
	List<Booking> getAllBookings() {
		return bookingRepo.findAll();
	}

	@GetMapping("/{bookingId}")
	Booking getAllBookings(@PathVariable Long bookingId) {
		return bookingRepo.findById(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));
	}

}
