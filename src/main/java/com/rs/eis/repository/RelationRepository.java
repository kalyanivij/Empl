package com.rs.eis.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Address;
import com.rs.eis.model.Relation;
import com.rs.eis.model.User;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Integer> {
	List<Relation> findByrelationid(int relationid);
	
}
