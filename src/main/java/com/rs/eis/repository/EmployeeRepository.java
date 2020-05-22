<<<<<<< HEAD
package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// User login(String userName, String password);

	List<Employee> findByAadharNo(String aadharNo);

	Optional<Employee> findById(int id);
	

}
=======
package com.rs.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
