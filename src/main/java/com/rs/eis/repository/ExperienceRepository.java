package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
	//Optional<Experience> findById(int employeeid);

}
