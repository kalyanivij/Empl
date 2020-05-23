package com.rs.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rs.eis.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

}
