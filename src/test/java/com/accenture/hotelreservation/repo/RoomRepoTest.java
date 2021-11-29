package com.accenture.hotelreservation.repo;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.accenture.hotelreservation.model.Booking;
import com.accenture.hotelreservation.model.Guest;
import com.accenture.hotelreservation.model.Room;
import com.accenture.hotelreservation.repository.BookingRepo;
import com.accenture.hotelreservation.repository.GuestRepo;
import com.accenture.hotelreservation.repository.RoomRepo;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoomRepoTest {

	@Autowired
	RoomRepo roomRepo;
	@Autowired
	BookingRepo bookingRepo;
	@Autowired
	GuestRepo guestRepo;

	@Test
	void testSave() {
		Room room = new Room().setPrice(125.00);
		roomRepo.save(room);
		Assertions.assertNotNull(room.getId());
	}

	@Test
	void testUpdate() {
		Room room = new Room().setPrice(124.00);
		roomRepo.save(room);
		Long roomId = room.getId();
		Assertions.assertNotNull(roomId);
		Assertions.assertEquals(room.getPrice(), 124.00);

		room = roomRepo.getById(roomId);
		room.setPrice(125.00);
		roomRepo.save(room);
		// assert that save didnt screate new row in the table
		Assertions.assertEquals(roomId, room.getId());
	}

	@Test
	void testDelete() {
		Room room = new Room().setPrice(125.00);
		roomRepo.save(room);
		Assertions.assertNotNull(room.getId());
		Assertions.assertEquals(roomRepo.count(), 1);

		roomRepo.delete(room);
		Assertions.assertEquals(roomRepo.count(), 0);
	}
/*
	@Test
	void testRoomsAvailable() {
		Guest guest1 = new Guest().fullname("Guest1");
		Booking booking1 = new Booking().startDate(LocalDate.of(2021, 11, 28)).endDate(LocalDate.of(2021, 11, 29))
				.guest(guest1);
		Room room1 = new Room().price(125.00).bookings(Set.of(booking1));
		Room room2 = new Room().price(250.00);
		roomRepo.save(room1);
		roomRepo.save(room2);

		Assertions.assertEquals(roomRepo.count(), 2);

		LocalDate bookingStartDate = LocalDate.of(2021, 11, 29);
		LocalDate bookingEndDate = LocalDate.of(2021, 11, 30);
		Set<Room> unoccupiedRooms2 = roomRepo
				.findByBookingsIsNullOrBookings_startDateGreaterThanEqualOrBookings_endDateLessThanEqual(bookingEndDate,
						bookingStartDate);
		System.out.println(unoccupiedRooms2);
		Assertions.assertTrue(unoccupiedRooms2.stream().anyMatch(room -> room.id() == room1.id()));
		Assertions.assertTrue(unoccupiedRooms2.stream().anyMatch(room -> room.id() == room2.id()));
	}

	@Test
	void testRoomsAvailable2() {
		Guest guest1 = new Guest().fullname("Guest1");
		guestRepo.save(guest1);
		Room room1 = new Room().price(125.00);
		Room room2 = new Room().price(250.00);
		roomRepo.save(room1);
		roomRepo.save(room2);
		roomRepo.count();
		Booking booking1 = new Booking().startDate(LocalDate.of(2021, 11, 28)).endDate(LocalDate.of(2021, 11, 29))
				.guest(guest1).rooms(Set.of(room1));
		bookingRepo.save(booking1);
		System.out.println(bookingRepo.count());
		LocalDate bookingStartDate = LocalDate.of(2021, 11, 28);
		LocalDate bookingEndDate = LocalDate.of(2021, 11, 29);
		Set<Room> unoccupiedRooms2 = roomRepo
				.findByBookingsIsNullOrBookings_startDateGreaterThanEqualOrBookings_endDateLessThanEqual(bookingEndDate,
						bookingStartDate);
		System.out.println(unoccupiedRooms2);
		Assertions.assertTrue(unoccupiedRooms2.stream().anyMatch(room -> room.id() == room1.id()));
		Assertions.assertFalse(unoccupiedRooms2.stream().anyMatch(room -> room.id() == room2.id()));
	}
*/
}
