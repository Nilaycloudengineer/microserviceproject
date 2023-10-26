package com.lulu.Lulu02_recap_MS1.controller;

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

import com.lulu.Lulu02_recap_MS1.entity.Employee;
import com.lulu.Lulu02_recap_MS1.repo.EmployeeRepo;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeRepo emprepo;

	@GetMapping("/emp")
	public List<Employee> getJPQL() {
		return emprepo.findAll();
	}

	@PostMapping("/emp")
	public Employee createuser(@RequestBody Employee prod) {
		return emprepo.save(prod);
	}

	@DeleteMapping("/emp/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		emprepo.deleteById(id);
	}

	@PatchMapping("/emp/{id}")
	public Employee updateUserInfo(@PathVariable("id") Integer id) {
		Employee newUser = emprepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newUser.setDept("Finance");
		return emprepo.save(newUser);
	}

	@PutMapping("/emp/{id}")
	public Employee updateUser(@PathVariable("id") Integer id, @RequestBody Employee userBody) {
		Optional<Employee> user1 = emprepo.findById(id);
		Employee newUser = emprepo.findById(id) // old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newUser.setDept(userBody.getDept()); // the new data replaces the old data.
		newUser.setName(userBody.getName());
		return emprepo.save(newUser);

	}

}
