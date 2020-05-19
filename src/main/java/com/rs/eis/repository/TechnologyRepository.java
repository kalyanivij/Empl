package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Address;
import com.rs.eis.model.Experience;
import com.rs.eis.model.Technology;
import com.rs.eis.model.User;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

	Optional<Technology> findById(Technology technology);

}
