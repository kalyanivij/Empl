package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.eis.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
	
	Country findByName(String name);
	
	Optional<Country> findById(int id);

}
