package com.moviehunter.movie.repo.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.moviehunter.movie.repo.ISearchService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class SearchRepository implements ISearchService {
	private final JdbcTemplate jdbcTemplate;
	
	
}
