package com.accenture.hotelreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.accenture.hotelreservation.model.Guest;

public interface GuestRepo extends JpaRepository<Guest, Long> {

}
