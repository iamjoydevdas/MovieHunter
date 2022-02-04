package com.moviehunter.movie.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ScreenSeat {
	@Id
	private Integer screenSeatId;
	
	private String seatNumber;
	private String seatType;
	private String price;
	private String screenTheatreSeatId;
}
