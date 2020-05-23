package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Circle;
import com.rs.eis.model.Departments;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Integer>
{

	Optional<Circle> findById(int Id);
	
	List<Circle> findByName(String name);
	Optional<Circle> findByOther(String other);
	
	List<Circle> findAllById(Integer id);
}
