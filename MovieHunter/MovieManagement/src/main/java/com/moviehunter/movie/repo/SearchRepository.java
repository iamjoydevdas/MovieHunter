package com.moviehunter.movie.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.moviehunter.movie.entity.City;

public interface SearchRepository extends CrudRepository<City, Integer> {
	@Query("SELECT c FROM City c")
	public List<City> getAllCity();
}
