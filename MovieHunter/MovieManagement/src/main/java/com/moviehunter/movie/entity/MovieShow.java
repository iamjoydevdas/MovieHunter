package com.moviehunter.movie.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	
//	private Integer movieShowMovieId;
}
/*
 * MOVIE_SHOW_ID INT(4) NOT NULL AUTO_INCREMENT, MOVIE_SHOW_DATE DATETIME NOT
 * NULL, MOVIE_SHOW_STARTTIME VARCHAR(10) NULL NULL, MOVIE_SHOW_ENDTIME
 * VARCHAR(10) NOT NULL, MOVIE_SHOW_THEATRE_ID INT(4) NOT NULL,
 * MOVIE_SHOW_MOVIE_ID INT(4) NOT NULL,
 */