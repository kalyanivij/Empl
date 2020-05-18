package com.rs.esi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.esi.model.Emp_awards;
import com.rs.esi.model.User;

@Repository
public interface Emp_awardsRepository extends JpaRepository<Emp_awards, Integer>{
	
	// Find employee by (int employeeid)
	
	
	List<Emp_awards> findByemployeeid(int employeeid);
	

	

}
