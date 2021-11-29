package com.accenture.hotelreservation.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@Accessors(chain = true)
@Entity
public class Room {

	@Id
	@GeneratedValue
	private Long id;
	private double price;

	@JsonBackReference
	@ManyToMany(mappedBy = "rooms", fetch = FetchType.LAZY)
	private Set<Booking> bookings;
//
//	public boolean equals(Object other) {
//		if (this == other)
//			return true;
//		if (!(other instanceof Room))
//			return false;
//		final Room room = (Room) other;
//
//		if (!room.getId().equals(getId()))
//			return false;
//		return true;
//	}

	public String toString() {
		return "Room = " + this.id;
	}
//
//	public int hashCode() {
//		return Objects.hash(13 * this.id);
//	}

}
