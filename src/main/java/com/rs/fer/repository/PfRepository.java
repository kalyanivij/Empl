package com.rs.fer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.model.Pf;

@Repository
public interface PfRepository extends JpaRepository<Pf, Integer> {

}
