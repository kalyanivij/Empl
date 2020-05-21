package com.rs.eis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	// User login(String userName, String password);
	
//	List<User> findByEmail(String email);
//	
//	List<User> findByUserNameAndPassword(String userName, String password);
	
}
