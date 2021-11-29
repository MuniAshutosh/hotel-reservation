package com.accenture.hotelreservation.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.hotelreservation.exception.RoomNotFoundException;
import com.accenture.hotelreservation.model.Room;
import com.accenture.hotelreservation.model.types.Response;
import com.accenture.hotelreservation.repository.BookingRepo;
import com.accenture.hotelreservation.repository.RoomRepo;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

	@Autowired
	private RoomRepo roomRepo;
	
	@Autowired
	private BookingRepo bookingRepo;

	@GetMapping("/test")
	public String test() {
		return "OK";
	}

	@GetMapping("/rooms")
	public List<Room> all() {
		return roomRepo.findAll();
	}

	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room) {
		return roomRepo.save(room);
	}

	@GetMapping("/rooms/{id}")
	public Room findRoom(@PathVariable Long id) {
		return roomRepo.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
	}

	@PutMapping("/rooms/{id}")
	public Room modifyRoom(@RequestBody Room newRoom, @PathVariable Long id) {
		return roomRepo.findById(id).map(room -> {
			room.setBookings(newRoom.getBookings()).setPrice(newRoom.getPrice());
			return roomRepo.save(room);
		}).orElseThrow(() -> new RoomNotFoundException(id));
	}

	@DeleteMapping("/rooms/{id}")
	public void deleteRoom(@PathVariable Long id) {
		roomRepo.deleteById(id);
	}
	
	
	
	

	Response failureOperation() {
		return Response.builder().message("Failed to perform operation").status(HttpStatus.INTERNAL_SERVER_ERROR)
				.timeStamp(LocalDateTime.now()).build();
	}

	Response successOperation() {
		return Response.builder().message("Operation Succesful").status(HttpStatus.OK).timeStamp(LocalDateTime.now())
				.build();
	}

}
