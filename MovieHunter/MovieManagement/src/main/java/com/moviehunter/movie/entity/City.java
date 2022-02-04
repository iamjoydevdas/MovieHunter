package com.moviehunter.movie.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="CITY")
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CITY_ID")
	private Integer cityId;
	@Column(name="CITY_NAME")
	private String cityName;
	@Column(name="CITY_STATE")
	private String cityState;
	@Column(name="CITY_PIN")
	private String cityPin;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "cityId", cascade=CascadeType.ALL)
	private List<Theatre> theatres;

	public City(Integer cityId, String cityName, String cityState, String cityPin) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityState = cityState;
		this.cityPin = cityPin;
	}
	
}
