package com.moviehunter.movie.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ShowSeat {
	@Id
	private Integer id;
	private String showSeatStatus;
	private Integer screenSeatId;
	private Integer movieShowId;
	private Integer bookingId;
}

