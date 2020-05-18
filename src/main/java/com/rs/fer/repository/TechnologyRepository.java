package com.rs.fer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.model.Address;
import com.rs.fer.model.Experience;
import com.rs.fer.model.Technology;
import com.rs.fer.model.User;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
	static Optional<Technology> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	}

