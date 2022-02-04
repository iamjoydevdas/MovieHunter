package com.moviehunter.movie.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="screenSeatId")
	private List<ShowSeat> tickets;
}
