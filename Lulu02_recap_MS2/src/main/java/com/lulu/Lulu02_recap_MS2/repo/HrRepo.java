package com.lulu.Lulu02_recap_MS2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lulu.Lulu02_recap_MS2.entity.HrManagment;

public interface HrRepo extends JpaRepository<HrManagment, Integer> {

}
