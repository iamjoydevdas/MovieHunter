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
//	@JoinColumn(name="screenId")
	private List<MovieShow> movieShow;
}

/*
 * SCREEN_ID INT(4) NOT NULL AUTO_INCREMENT, SCREEN_NAME VARCHAR(64) NOT NULL,
 * TOTAL_SEATS INT(4) NULL NULL, SCREEN_THEATRE_ID INT(4) NOT NULL,
 */