package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

	// User login(String userName, String password);

	// List<Timesheet> findByAadharNo(String aadharNo);
	//
	 Optional<Timesheet> findByallocationId(int allocationId);

	// Optional<Timesheet> findByemployeeId(int employeeId);

	List<Timesheet> findByDepartmentId(int departmentId);

	List<Timesheet> findByAllocationId(int allocationId);

}
