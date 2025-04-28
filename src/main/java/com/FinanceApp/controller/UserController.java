package com.FinanceApp.controller;

import com.FinanceApp.service.UserService;

public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
}
