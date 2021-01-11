package com.cosmos.controller;

import com.cosmos.model.Users;
import com.cosmos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;

	// Get All users
	@GetMapping
	public List<Users> getAllUsers() {
		log.info("getAllUsers called");
		return userService.getAllUsers();
	}

	// Save/Update a user
	@PostMapping
	public Users saveUser(@RequestBody Users user) {
		log.info("saveUser got called");
		return userService.saveUser(user);
	}

	// Get user by mobileNumber
	@GetMapping("/{mobileNumber}")
	public Optional<Users> getUserByMobileNumber(@PathVariable Long mobileNumber) {
		log.info("getUserByMobileNumber called for :"+mobileNumber);
		return userService.getUserByMobileNumber(mobileNumber);
	}


	// Get all users added yesterday
	@GetMapping("/yesterday")
	public Optional<List<Users>> getAllUsersAddedYesterday() {
		return userService.getAllUsersAddedYesterday();
	}
	@GetMapping("/vwhatsapponly/{b}")
	public List<Users> getAllUsersWhatsappOnly(@PathVariable boolean b) {
		return userService.getAllUsersWhatsappOnly(b);
	}
	@GetMapping("/vbyaddeddate/{addedDate}")
	public List<Users> getAllUsersByAddedDate(@PathVariable LocalDate addedDate) {
		return userService.getAllUsersByAddedDate(addedDate);
	}

}
