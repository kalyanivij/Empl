package com.rs.fer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.model.Expense;
import com.rs.fer.model.Transportation;

@Repository

public interface TransportationRepository extends JpaRepository<Transportation, Integer> {
	Optional<Transportation> findById(int Id);

}
