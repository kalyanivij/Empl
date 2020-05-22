package com.rs.eis.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

	List<Allocation> findByProjectid(int projectid);

}

