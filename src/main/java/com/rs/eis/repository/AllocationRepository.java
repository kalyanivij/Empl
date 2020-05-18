package com.rs.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Allocations;

@Repository
public interface AllocationRepository extends JpaRepository<Allocations, Integer> {

}
