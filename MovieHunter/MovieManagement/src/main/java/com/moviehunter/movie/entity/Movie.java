package com.moviehunter.movie.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Movie {
	
	@Id
	private Integer movieId;
	
	private String movieTitle;
	private String movieDescription;
	private String duration;
	private String lang;
	private LocalDate releaseDate;
	private String country;
	private String genere;
	
	
}
