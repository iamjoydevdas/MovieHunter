package com.moviehunter.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class MovieHunterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpStatus errorCode;
	private String errorMessage;
	
	public MovieHunterException() {
		// TODO Auto-generated constructor stub
	}

	public MovieHunterException(String errorMessage) {
		super();
		this.errorCode = HttpStatus.NOT_FOUND;
		this.errorMessage = errorMessage;
	}
	
	public MovieHunterException(HttpStatus errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	
}
