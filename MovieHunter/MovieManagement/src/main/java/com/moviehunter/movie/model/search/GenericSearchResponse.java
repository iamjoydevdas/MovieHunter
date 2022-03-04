package com.moviehunter.movie.model.search;

import java.util.List;

import com.moviehunter.movie.entity.Movie;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericSearchResponse {
	
	private GenericMovie movies;
	private GenericLanguage language;
	
	static public class GenericMovie {
		private List<Movie> movie;
	}
	
	static public class GenericLanguage {
		private List<Movie> byLanguage;
	}
	
	static public class GenericGenere {
		private List<Movie> byGenere;
	}
}
