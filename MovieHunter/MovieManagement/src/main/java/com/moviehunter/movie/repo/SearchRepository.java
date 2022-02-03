package com.moviehunter.movie.repo;

import org.springframework.data.repository.CrudRepository;

import com.moviehunter.movie.entity.City;

public interface SearchRepository extends CrudRepository<City, Integer> {

}
