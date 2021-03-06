package com.moviehunter.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class ServiceResponse<T> {
	private boolean success;
	private Errors error;
	private T data;
	private String additionalMessage;
	
	@Data
	@Builder
	public static class Errors {
		private HttpStatus errorCode;
		private String errorMessage;
	}
}
