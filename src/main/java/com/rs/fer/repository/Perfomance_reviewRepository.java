package com.rs.fer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.model.Perfomance_Review;
import com.rs.fer.model.User;

@Repository
public interface Perfomance_reviewRepository extends JpaRepository<Perfomance_Review, Integer>{
	
	List<Perfomance_Review> findByemployeeid(int employeeid);
	
}
