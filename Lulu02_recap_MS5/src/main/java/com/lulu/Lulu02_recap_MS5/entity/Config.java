package com.lulu.Lulu02_recap_MS5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Config {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Config(Long id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Config [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

	// Getters and setters
}