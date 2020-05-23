package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Departments;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Integer>
{

	Optional<Departments> findById(int id);
	
	//List<Department> findEmployerId(int employerid);
	
	Optional<Departments> findByName(String name);
	
	List<Departments> findAllById(int id);
	
	//Optional<Department> findByEmployerId(int employerid);
	
	
	
		
}
