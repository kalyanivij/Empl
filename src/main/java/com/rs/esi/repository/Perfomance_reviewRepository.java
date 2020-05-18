package com.rs.esi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.esi.model.Perfomance_Review;

@Repository
public interface Perfomance_reviewRepository extends JpaRepository<Perfomance_Review, Integer>{
	

	
	
	List<Perfomance_Review> findByemployeeid(int employeeid);

	
	
	
}
