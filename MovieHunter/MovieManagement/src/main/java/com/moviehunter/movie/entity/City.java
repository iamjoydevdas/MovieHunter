package com.moviehunter.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="CITY")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CITY_ID")
	private Integer cityId;
	//@Column(name="CITY_NAME")
	private String cityName;
	//@Column(name="CITY_STATE")
	private String cityState;
	//@Column(name="CITY_PIN")
	private String cityPin;
}
