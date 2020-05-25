package com.rs.eis.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Prefix;

@Repository
public interface PrefixRepository extends JpaRepository<Prefix ,Integer> {
	Optional<Prefix> findById(int Id);

}
