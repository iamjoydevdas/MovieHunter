package com.moviehunter.movie.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviehunter.movie.entity.City;
import com.moviehunter.movie.entity.Movie;
import com.moviehunter.movie.entity.Theatre;
import com.moviehunter.movie.repo.CityRepository;
import com.moviehunter.movie.repo.MovieRepository;
import com.moviehunter.movie.repo.TheatreRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api
@RestController
@AllArgsConstructor
public class SearchController {
	private final CityRepository searchRepository;
	private final TheatreRepository theatreRepository;
	private final MovieRepository movieRepository;
	
	
	@ApiOperation(value="/cities")
	@RequestMapping(value="/cities", method= RequestMethod.GET)
	public ResponseEntity<List<City>> getCities() {
		List<City> allCity = searchRepository.getAllCity();
		return new ResponseEntity<List<City>>(allCity, HttpStatus.OK);
	}
	
	@RequestMapping(value="/theatre", method= RequestMethod.GET)
	public ResponseEntity<List<Theatre>> getMoviesInCity() {
		List<Theatre> list = new ArrayList<Theatre>();
		Iterable<Theatre> findAll = theatreRepository.findAll();
		findAll.forEach(th -> list.add(th));
		return new ResponseEntity<List<Theatre>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{cityId}/theatres", method= RequestMethod.GET)
	public ResponseEntity<List<Theatre>> getTheatreByCities(@PathVariable("cityId") Integer cityId) {
		List<Theatre> theatres = searchRepository.getTheatresByCity(cityId).getTheatres();
		return new ResponseEntity<>(theatres, HttpStatus.OK);
	}
	
	@RequestMapping(value="/movies", method= RequestMethod.GET)
	public ResponseEntity<List<Movie>> getMovies() {
		return new ResponseEntity<>(movieRepository.getAllMovies(), HttpStatus.OK);
	}
}
