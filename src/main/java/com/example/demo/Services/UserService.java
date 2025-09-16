package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entities.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getUserDetails( int id);
	public User updateUserDetails(int id, User newUser);
	public void deletedUserDetails(int id);
}
