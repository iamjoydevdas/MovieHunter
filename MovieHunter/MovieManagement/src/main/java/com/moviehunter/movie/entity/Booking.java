package com.moviehunter.movie.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	private 
}

