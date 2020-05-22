package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.eis.model.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Integer> {

	Optional<Certification> findByEmployeeIdAndType(int employeeId, String type);
	
	List<Certification> findByEmployeeId(int employeeId);

	Optional<Certification> findByCertificationId(int certificationId);



	//Optional<Certification> save(Optional<Certification> certiObj);
}