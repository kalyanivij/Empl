package com.rs.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Trainings;

@Repository
public interface TrainingsRepository extends JpaRepository<Trainings, Integer> {

	List<Trainings> findByemployee(int employeeid);

	List<Trainings> findByemployer(int employerid);

}
