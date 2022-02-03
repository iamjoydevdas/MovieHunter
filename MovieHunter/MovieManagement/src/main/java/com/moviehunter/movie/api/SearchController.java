package com.moviehunter.movie.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviehunter.movie.entity.City;
import com.moviehunter.movie.repo.SearchRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SearchController {
	private final SearchRepository searchRepository;
	
	@RequestMapping(value="/cities", method= RequestMethod.GET)
	public ResponseEntity<List<City>> getCities() {
		List<City> list = new ArrayList<>();
		List<City> allCity = searchRepository.getAllCity();
		/*
		 * Iterable<City> findAll = searchRepository.getAllCity(); findAll.forEach(city
		 * -> { list.add(city); });
		 */
		return new ResponseEntity<List<City>>(allCity, HttpStatus.OK);
	}
}
