package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
 

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name is required") 
	@Size(max = 50 , message = "Max 50 character allowed !")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "Email is required !")
	@Column(nullable = false , unique = true)
	private String email;
	
	@NotBlank(message = "Password is required !")
	@Size(min = 6, message = "Password must be at least character")
	@Column(nullable = false)
	private String password;
	
	@NotBlank(message = "City name is required !")
	@Column(nullable = false)
	private String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
