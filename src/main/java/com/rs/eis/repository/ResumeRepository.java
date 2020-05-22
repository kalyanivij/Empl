package com.rs.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {

}
