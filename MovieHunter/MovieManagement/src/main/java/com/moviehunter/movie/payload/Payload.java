package com.moviehunter.movie.payload;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;


@Valid
public class Payload {
	@NonNull
	@NotEmpty
	private Integer locationCode;
	private String searchText;
}
