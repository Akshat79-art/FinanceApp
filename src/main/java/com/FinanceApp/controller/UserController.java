package com.FinanceApp.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FinanceApp.dto.UserDto;
import com.FinanceApp.model.User;
import com.FinanceApp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping(value = "/registerUser")
	public ResponseEntity<String> handleNewUser(
			@RequestParam String name,  @RequestParam String password, @RequestParam String email, @RequestParam String role) throws Exception{
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setRole(role);
		user.setCreatedAt(LocalDateTime.now());
		user.setPassword(passwordEncoder.encode(password));
		userService.saveUser(user);
		
		return ResponseEntity.ok("User persisted.");
	}
	
	@GetMapping(value = "/user")
	public ResponseEntity<UserDto> getUser(@RequestParam String email){
		User user = userService.getUserByEmail(email); 
		UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail(), user.getRole());
		return ResponseEntity.ok(userDto);
	}
	
	@PutMapping(value = "/user/updateEmail")
	public ResponseEntity<String> updateEmail(@RequestParam String oldEmail, @RequestParam String newEmail){
		userService.updateEmail(oldEmail, newEmail);
		return ResponseEntity.ok("Email updated.");
	}
}
