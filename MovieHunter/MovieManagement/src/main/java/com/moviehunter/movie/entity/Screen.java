package com.moviehunter.movie.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Screen {
	@Id
	private Integer screenId;
	private String screenName;
	private Integer totalSeats;
	private Integer screenTheatreId;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="movieShowScreenId")
	private List<MovieShow> movieShow;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="screenTheatreSeatId")
	private List<ScreenSeat> screenSeats;
}

