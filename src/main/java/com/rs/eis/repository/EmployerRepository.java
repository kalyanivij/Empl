package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

	Optional<Employer> findById(int id);

	List<Employer> findByBranch(String branch);

	// List<Employer> findByUserIdAndTypeAndDateBetween(int userId,String
	// type,String fromDate,String toDate);

}