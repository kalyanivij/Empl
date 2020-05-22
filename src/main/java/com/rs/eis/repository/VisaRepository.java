package com.rs.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Visa;

@Repository
public interface VisaRepository extends JpaRepository<Visa, Integer> {

	List<Visa> findByemployeeid(int employeeid);

}
