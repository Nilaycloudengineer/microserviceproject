package com.lulu.Lulu02_recap_MS4.controller;

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

import com.lulu.Lulu02_recap_MS4.entity.Payroll;
import com.lulu.Lulu02_recap_MS4.repo.PayrollRepo;

@RestController
@CrossOrigin
@RequestMapping("/payroll")
public class PayrollController {
	@Autowired
	PayrollRepo payrepo;

	@GetMapping("/pay")
	public List<Payroll> getJPQL() {
		return payrepo.findAll();
	}

	@PostMapping("/pay")
	public Payroll createuser(@RequestBody Payroll prod) {
		return payrepo.save(prod);
	}

	@DeleteMapping("/pay/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		payrepo.deleteById(id);
	}

	@PatchMapping("/pay/{id}")
	public Payroll updateUserInfo(@PathVariable("id") Integer id) {
		Payroll newPay = payrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newPay.setSal(25000);
		return payrepo.save(newPay);
	}

	@PutMapping("/pay/{id}")
	public Payroll updatePay(@PathVariable("id") Integer id, @RequestBody Payroll payBody) {
		Optional<Payroll> pay1 = payrepo.findById(id);
		Payroll newPay = payrepo.findById(id) // old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newPay.setName(payBody.getName()); // the new data replaces the old data.
		newPay.setSal(payBody.getSal());
		return payrepo.save(newPay);

	}

}
