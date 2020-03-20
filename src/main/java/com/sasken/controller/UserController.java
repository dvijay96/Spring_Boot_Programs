package com.sasken.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasken.model.User;
import com.sasken.repository.UserRepository;

@RestController
@RequestMapping("/app/user")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/details/{id}")
	public Optional<User> getUserDetails(@PathVariable int id) {
		return repo.findById(id);
	}
}
