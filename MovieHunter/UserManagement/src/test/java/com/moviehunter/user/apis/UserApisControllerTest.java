package com.moviehunter.user.apis;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.moviehunter.user.api.UserApisController;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserApisControllerTest {
	
	@InjectMocks
	private UserApisController userApisController;
	
	@Test
	@DisplayName("This will test the user registration")
	public void registerTest() {
		String txt = userApisController.register().getBody();
		assertEquals("User has been created", txt);
	}
	
	@Test
	@DisplayName("This will test the user login")
	public void loginTest() {
		String txt = userApisController.login().getBody();
		assertEquals("User logged in.", txt);
	}
}

