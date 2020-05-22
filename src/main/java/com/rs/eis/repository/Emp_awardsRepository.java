package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Emp_awards;

@Repository
public interface Emp_awardsRepository extends JpaRepository<Emp_awards, Integer> {

	List<Emp_awards> findByemployeeid(int employeeid);

	Optional<Emp_awards> findById(int id);

	Optional<Emp_awards> findByid(int id);
	

}
