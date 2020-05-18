package com.rs.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

	List<Insurance> findByemployeeid(int employeeid);
}
