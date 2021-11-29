package com.accenture.hotelreservation;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.accenture.hotelreservation.model.Booking;
import com.accenture.hotelreservation.model.Guest;
import com.accenture.hotelreservation.model.Room;
import com.accenture.hotelreservation.repository.BookingRepo;
import com.accenture.hotelreservation.repository.GuestRepo;
import com.accenture.hotelreservation.repository.RoomRepo;

@SpringBootApplication
public class HotelReservationApplication {
	@Autowired
	private RoomRepo roomRepo;

	@Autowired
	private GuestRepo guestRepo;

	@Autowired
	private BookingRepo bookingRepo;

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {

			// Create 3 rooms
			Room room1 = new Room().setPrice(125.00);
			Room room2 = new Room().setPrice(250.00);
			Room room3 = new Room().setPrice(500.00);
			roomRepo.save(room1);
			roomRepo.save(room2);
			roomRepo.save(room3);

			// create 2 guest
			Guest guest1 = new Guest().setFullname("Guest1");
			Guest guest2 = new Guest().setFullname("Guest2");
			guestRepo.save(guest1);
			guestRepo.save(guest2);

			// create a booking
			Booking booking1 = new Booking().setStartDate(LocalDate.of(2021, 11, 28)).setEndDate(LocalDate.of(2021, 11, 29))
					.setGuest(guest1).setRooms(Set.of(room1, room2));
			bookingRepo.save(booking1);
//
//			/// fetch all unbooked rooms
//			Set<Room> unoccupiedRooms = roomRepo.findByBookingsIsNull();
//			System.out.println(unoccupiedRooms);
//
//			// endDate after startdate
//			// startDate should not be before today
//			LocalDate bookingStartDate = LocalDate.now().plusDays(1);
//			LocalDate bookingEndDate = LocalDate.now().plusDays(2);
//			Set<Room> unoccupiedRooms2 = roomRepo
//					.findByBookingsIsNullOrBookings_startDateGreaterThanEqualOrBookings_endDateLessThanEqual(
//							bookingEndDate, bookingStartDate);
//			System.out.println(unoccupiedRooms2);
		};

	}
}
