package com.sasken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasken.model.User;
import com.sasken.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostMapping("/create/user")
	public String addUser(@RequestBody User user) {
		String encrytpwd = encoder.encode(user.getPassword());
		user.setPassword(encrytpwd);
		repo.save(user);

		return "user added successfully";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("all")
	public List<User> hello() {
		return repo.findAll();
		
	}
}
