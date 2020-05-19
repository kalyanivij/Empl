package com.rs.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}
