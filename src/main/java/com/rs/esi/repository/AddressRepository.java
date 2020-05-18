package com.rs.esi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.esi.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
