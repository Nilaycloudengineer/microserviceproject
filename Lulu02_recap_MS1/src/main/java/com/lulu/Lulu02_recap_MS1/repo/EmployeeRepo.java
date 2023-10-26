package com.lulu.Lulu02_recap_MS1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lulu.Lulu02_recap_MS1.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
