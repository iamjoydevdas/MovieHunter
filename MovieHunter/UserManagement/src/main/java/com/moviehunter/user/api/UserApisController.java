package com.moviehunter.user.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
public class UserApisController {
	@GetMapping("Ok")
	public ResponseEntity<String> register() {
		return new ResponseEntity<String>("User has been created", HttpStatus.OK);
	}
	@ApiOperation(value="/cities")
	@GetMapping("Oks")
	public ResponseEntity<String> login() {
		return new ResponseEntity<String>("User logged in.", HttpStatus.OK);
	}

}
