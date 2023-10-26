package com.lulu.Lulu02_recap_MS6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu.Lulu02_recap_MS6.entity.User;
import com.lulu.Lulu02_recap_MS6.repo.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		if (userRepository.existsById(id)) {
			user.setId(id);
			return userRepository.save(user);
		}
		return null; // Handle not found case
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
}
