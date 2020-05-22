package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary ,Integer> {

	

	Optional<Salary> findById(Integer id);
}