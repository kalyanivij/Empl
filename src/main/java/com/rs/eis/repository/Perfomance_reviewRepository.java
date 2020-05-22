package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Perfomance_review;

@Repository
public interface Perfomance_reviewRepository extends JpaRepository<Perfomance_review, Integer>{
	

	
	
	Optional<Perfomance_review> findByemployeeid(int employeeid);

	

	
	
	
}
