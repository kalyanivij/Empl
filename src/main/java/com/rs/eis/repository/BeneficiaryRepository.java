
package com.rs.eis.repository;


	
	
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Beneficiary;
import com.rs.eis.model.Employee;
	 
	@Repository
	public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer>{
	 
	    

		public Beneficiary save(Beneficiary beneficiary);
}


