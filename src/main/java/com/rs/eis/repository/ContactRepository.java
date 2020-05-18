package com.rs.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	List<Contact> findByEmployee(int employeeid);

	List<Contact> findByEmployer(int employerid);
}
