package com.moviehunter.movie.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moviehunter.movie.entity.City;

public interface CityRepository extends CrudRepository<City, Integer> {
	@Query("SELECT new City(c.cityId,c.cityName, c.cityState, c.cityPin) FROM City c")
	public List<City> getAllCity();
	
	@Query("Select c from City c where c.cityId = :cityId")
	public City getTheatresByCity(@Param("cityId") Integer cityId);
}
