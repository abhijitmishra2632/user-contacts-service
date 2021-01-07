package com.cosmos.controller;

import com.cosmos.model.Users;
import com.cosmos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	// Get All users
	@GetMapping
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	// Save/Update a user
	@PostMapping
	public Users saveUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}

	// Get user by mobileNumber
	@GetMapping("/{mobileNumber}")
	public Optional<Users> getUserByMobileNumber(@PathVariable Long mobileNumber) {
		return userService.getUserByMobileNumber(mobileNumber);
	}

	// Backup to other DB
	@GetMapping("/backup")
	public String backupUsers() {
		return userService.backupUsers();
	}

	// Get all users added yesterday
	@GetMapping("/yesterday")
	public Optional<List<Users>> getAllUsersAddedYesterday() {
		return userService.getAllUsersAddedYesterday();
	}

	/*
	 * // Get All users to a excel file
	 * 
	 * @GetMapping("/toexcel") public void getAllUsersToFile() throws IOException {
	 * userService.getAllUsersToFile(); }
	 * 
	 * // From All users to a excel file
	 * 
	 * @GetMapping("/fromexcel") public List<Users> getAllUsersFromFile() throws
	 * IOException, ClassNotFoundException { return
	 * userService.getAllUsersFromFile(); }
	 */
	@GetMapping("/vwhatsapponly/{b}")
	public List<Users> getAllUsersWhatsappOnly(@PathVariable boolean b) {
		return userService.getAllUsersWhatsappOnly(b);
	}
	@GetMapping("/vbyaddeddate/{addedDate}")
	public List<Users> getAllUsersByAddedDate(@PathVariable LocalDate addedDate) {
		return userService.getAllUsersByAddedDate(addedDate);
	}

	/*
	 * // enable when u want to copy from excel file
	 * 
	 * @GetMapping("/fromprop") public String addUsersFromFile() { String str =
	 * "Success"; try { str = userService.addUsersFromExcel2(); } catch (Exception
	 * e) { str = "Not able to update.Check if excel file there." + e; } return str;
	 * }
	 */

}
