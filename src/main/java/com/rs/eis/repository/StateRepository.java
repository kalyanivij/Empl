package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.eis.model.State;

public interface StateRepository extends JpaRepository<State,Integer> {
	
	List<State> findByName(String name);
	
	Optional<State> findById(int id);

	Optional<State> findByCountryId(int countryid);

	

}
