package com.rs.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rs.eis.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
