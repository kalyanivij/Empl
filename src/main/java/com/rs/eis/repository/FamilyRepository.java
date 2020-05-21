package com.rs.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Family;


@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {

	
	
	List<Family> findByemployeeid(int employeeid);
	
}
