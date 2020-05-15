package com.rs.fer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	List<Expense> findByUserId(int userId);
	List<Expense> findByUserIdAndTypeAndDateBetween(int userId,String type,String fromDate,String toDate);
	
}
