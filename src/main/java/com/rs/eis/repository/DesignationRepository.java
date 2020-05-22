package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> {

	Optional<Designation> findById(Integer id);
}
