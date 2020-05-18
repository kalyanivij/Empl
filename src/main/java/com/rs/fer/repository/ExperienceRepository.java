package com.rs.fer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.model.Experience;
import com.rs.fer.model.User;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
	static Optional<Experience> findById(int employeeid) {
		// TODO Auto-generated method stub
		return null;
	}


}
