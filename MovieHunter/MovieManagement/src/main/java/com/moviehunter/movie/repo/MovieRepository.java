package com.moviehunter.movie.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.moviehunter.movie.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
	
	@Query("SELECT m from Movie m")
	List<Movie> getAllMovies();
}
