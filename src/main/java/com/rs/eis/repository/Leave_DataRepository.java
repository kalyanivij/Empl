package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Leave_Data;

@Repository
public interface Leave_DataRepository extends JpaRepository<Leave_Data, Integer> {

	// User login(String userName, String password);
	
	Optional<Leave_Data> findById(int Id);




	
	//List<User> findByUserNameAndPassword(String userName, String password);
	
}
 