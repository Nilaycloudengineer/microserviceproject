package com.lulu.Lulu02_recap_MS3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu.Lulu02_recap_MS3.entity.Login;
import com.lulu.Lulu02_recap_MS3.repo.LoginRepo;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginRepo loginrepo;

	@GetMapping("/user")
	public List<Login> getJPQL() {
		return loginrepo.findAll();
	}

	@PostMapping("/user")
	public Login createuser(@RequestBody Login prod) {
		return loginrepo.save(prod);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		loginrepo.deleteById(id);
	}

	@PatchMapping("/user/{id}")
	public Login updateUserInfo(@PathVariable("id") Integer id) {
		Login newUser = loginrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newUser.setPassword("kp!123");
		return loginrepo.save(newUser);
	}

	@PutMapping("/user/{id}")
	public Login updateUser(@PathVariable("id") Integer id, @RequestBody Login userBody) {
		Optional<Login> user1 = loginrepo.findById(id);
		Login newUser = loginrepo.findById(id) // old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newUser.setPassword(userBody.getPassword()); // the new data replaces the old data.
		newUser.setUsername(userBody.getUsername());
		return loginrepo.save(newUser);

	}

}
