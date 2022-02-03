package com.moviehunter.movie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="THEATRE")
public class Theatre {
	@Id
	private Integer theatreId;
	
	private String theatreName;
	@Column(name="THEATRE_SCREENS")
	private String totalScreens;
	@Column(name="THEATRE_CITY_ID")
	private Integer cityId;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "screenTheatreId")
	private List<Screen> screens;
}
