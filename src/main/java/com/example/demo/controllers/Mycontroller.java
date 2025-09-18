package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.User;
import com.example.demo.Services.UserService;

import jakarta.validation.Valid;

@RestController
public class Mycontroller {
	@Autowired
	private UserService userService;
	
	// For Adding User ------
	
	@PostMapping("/user")
	public User addUserDetail(@Valid @RequestBody User user ) {
		return userService.createUser(user); 
	}
	
	// For Fetch All user Details -----
	@GetMapping("/user")
	public List<User> getAllUserDetail() {
		return userService.getAllUsers();
	}
	
	// For Fetch user detail via id ------
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetail(@PathVariable("id") int id){
		User user=userService.getUserDetails(id).orElse(null);
		if(user !=null) {
			return ResponseEntity.ok().body(user);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// For Updating user detail via id -------
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable("id") int id ,@Valid @RequestBody User user ){
		user.setId(id);
		User updatedUser= userService.updateUserDetails(id, user);
		if(updatedUser != null) {
			return ResponseEntity.ok(updatedUser);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// For Delete User Details ---------
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable("id") int id){
		userService.deletedUserDetails(id);
		return ResponseEntity.ok("User ID :"+ id +" Deleted Sucessfull !");
	}
}
