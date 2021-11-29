
package com.accenture.hotelreservation.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.accenture.hotelreservation.model.types.Name;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false, of = { "id" })
@Accessors(chain = true)
@Entity
public class Guest {

	@Id
	@GeneratedValue
	private long id;

	private String fullname;

	@JsonBackReference
	@OneToMany(mappedBy = "guest")
	private Set<Booking> bookings;

	public String toString() {
		return "Guest = " + this.id;
	}

}
