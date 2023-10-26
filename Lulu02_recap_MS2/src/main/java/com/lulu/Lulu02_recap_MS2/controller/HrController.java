package com.lulu.Lulu02_recap_MS2.controller;

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

import com.lulu.Lulu02_recap_MS2.entity.HrManagment;
import com.lulu.Lulu02_recap_MS2.repo.HrRepo;

@RestController
@CrossOrigin
@RequestMapping("/hrapi")
public class HrController {
	@Autowired
	HrRepo hrrepo;

	@GetMapping("/hr")
	public List<HrManagment> getJPQL() {
		return hrrepo.findAll();
	}

	@PostMapping("/hr")
	public HrManagment createuser(@RequestBody HrManagment prod) {
		return hrrepo.save(prod);
	}

	@DeleteMapping("/hr/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		hrrepo.deleteById(id);
	}

	@PatchMapping("/hr/{id}")
	public HrManagment updateUserInfo(@PathVariable("id") Integer id) {
		HrManagment newUser = hrrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newUser.setDept("Finance");
		return hrrepo.save(newUser);
	}

	@PutMapping("/hr/{id}")
	public HrManagment updateUser(@PathVariable("id") Integer id, @RequestBody HrManagment userBody) {
		Optional<HrManagment> user1 = hrrepo.findById(id);
		HrManagment newUser = hrrepo.findById(id) // old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newUser.setDept(userBody.getDept()); // the new data replaces the old data.
		newUser.setSal(userBody.getSal());
		return hrrepo.save(newUser);

	}

}
