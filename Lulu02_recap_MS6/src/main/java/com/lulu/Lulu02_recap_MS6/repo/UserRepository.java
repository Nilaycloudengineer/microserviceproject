package com.lulu.Lulu02_recap_MS6.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lulu.Lulu02_recap_MS6.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// You can add custom query methods here if needed.
}
