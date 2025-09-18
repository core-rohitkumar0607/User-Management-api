package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class UserServiceImp implements UserService { 
	@Autowired
	public UserRepository userRepository;
	@Override	
	public User createUser(User user) {
			
		return userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	@Override
	public Optional<User> getUserDetails(int id) {
		
		return userRepository.findById(id);
	}
	
		@Override
		public User updateUserDetails(int id, User newUser) {
		    User userData = userRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("User Not Found By ID: " + id));
		    userData.setName(newUser.getName());
		    userData.setEmail(newUser.getEmail());
		    userData.setPassword(newUser.getPassword());
		    userData.setCity(newUser.getCity());
		    return userRepository.save(newUser);
		}

//		if(userData!=null) {
//			return userRepository.save(newUser);
//		}
//		else {
//			throw new RuntimeException("User Not Found By ID :"+id);
//		}
//	}
	@Override
	public void deletedUserDetails(int id) {
		userRepository.deleteById(id);
		
	}
}
