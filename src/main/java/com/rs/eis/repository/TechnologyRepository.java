package com.rs.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

	//Optional<Technology> findById(Technology technology);

}
