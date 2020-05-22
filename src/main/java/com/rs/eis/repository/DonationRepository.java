package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rs.eis.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, String> {

	Optional<Donation> findById(Integer id);

	List<Donation> findByCode(String code);
}
