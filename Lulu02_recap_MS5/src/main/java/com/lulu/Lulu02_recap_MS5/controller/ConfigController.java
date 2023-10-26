package com.lulu.Lulu02_recap_MS5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu.Lulu02_recap_MS5.entity.Config;
import com.lulu.Lulu02_recap_MS5.repo.ConfigRepository;

@RestController
@RequestMapping("/configs")
public class ConfigController {

	@Autowired
	private ConfigRepository configRepository;

	// Create a new config
	@PostMapping("/")
	public Config createConfig(@RequestBody Config config) {
		return configRepository.save(config);
	}

	// Read all configs
	@GetMapping("/")
	public List<Config> getAllConfigs() {
		return configRepository.findAll();
	}

	// Read a specific config by ID
	@GetMapping("/{id}")
	public Optional<Config> getConfigById(@PathVariable Long id) {
		return configRepository.findById(id);
	}

	// Update an existing config
	@PutMapping("/{id}")
	public Config updateConfig(@PathVariable Long id, @RequestBody Config updatedConfig) {
		updatedConfig.setId(id); // Make sure the ID is set
		return configRepository.save(updatedConfig);
	}

	// Delete a config by ID
	@DeleteMapping("/{id}")
	public void deleteConfig(@PathVariable Long id) {
		configRepository.deleteById(id);
	}
}
