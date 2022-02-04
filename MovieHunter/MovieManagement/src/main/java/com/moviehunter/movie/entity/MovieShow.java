package com.moviehunter.movie.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class MovieShow {
	@Id
	private Integer movieShowId;
	private LocalDate movieShowDate;
	@Column(name="MOVIE_SHOW_STARTTIME")
	private String movieShowStartTime;
	@Column(name="MOVIE_SHOW_ENDTIME")
	private String movieShowEndTime;
	@Column(name="MOVIE_SHOW_SCREEN_ID")
	private Integer movieShowScreenId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="MOVIE_SHOW_MOVIE_ID")
	private Movie movie;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="bookingMovieShowId")
	private List<Booking> booking;
}
