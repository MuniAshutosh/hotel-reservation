package com.accenture.hotelreservation.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@Accessors(chain = true)
@Entity
public class Booking {

	@Id
	@GeneratedValue
	private long id;

	private LocalDate startDate;
	private LocalDate endDate;

	@JsonManagedReference
	@ManyToOne
	private Guest guest;

	@JsonManagedReference
	@ManyToMany
	private Set<Room> rooms;

	public String toString() {
		return "Booking = " + this.id;
	}

}
