package com.moviehunter.movie.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Booking {
	@Id
	private Integer bookingId;
	private Integer noOfSeats;
	private LocalDate timeOfBooking;
	private String bookingStatus;
	private Integer bookingMovieShowId;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="bookingId")
	private List<ShowSeat> tickets;
}

