package com.rs.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Trainings;

@Repository
public interface TrainingsEmployeeRepository extends JpaRepository<Trainings,Integer> {

	List<Trainings> findByEmployeeId(int employeeId);

}
