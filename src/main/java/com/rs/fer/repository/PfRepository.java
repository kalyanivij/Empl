package com.rs.fer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.model.Pf;
import com.rs.fer.model.Transportation;

@Repository
public interface PfRepository extends JpaRepository<Pf, Integer> {
	Optional<Pf> findById(int Id);
}
