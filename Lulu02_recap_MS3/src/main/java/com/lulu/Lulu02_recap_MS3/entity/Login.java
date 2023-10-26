package com.lulu.Lulu02_recap_MS3.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="login")
public class Login {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String username;
	String password;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	

}
