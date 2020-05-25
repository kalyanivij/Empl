package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Suffix;

@Repository
public interface SuffixRepository extends JpaRepository<Suffix, Integer> {
	
	Optional<Suffix> findById(int Id);
	
	//List<Suffix> findById(int Id);

}
 