package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Emp_Designation;

@Repository
public interface Emp_DesignationRepository extends JpaRepository<Emp_Designation, Integer> {

     Optional<Emp_Designation> findById(Integer id);
}