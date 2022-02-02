package com.moviehunter.user.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserApisController {

	public ResponseEntity<String> register() {
		return new ResponseEntity<String>("User has been created", HttpStatus.OK);
	}

	public ResponseEntity<String> login() {
		return new ResponseEntity<String>("User logged in.", HttpStatus.OK);
	}

}
