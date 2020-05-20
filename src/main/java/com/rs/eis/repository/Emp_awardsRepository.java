package com.rs.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Emp_awards;

@Repository
public interface Emp_awardsRepository extends JpaRepository<Emp_awards, Integer>{
	
	// Find employee by (int employeeid)
	
	
	List<Emp_awards> findByemployeeid(int employeeid);
	

	

}
