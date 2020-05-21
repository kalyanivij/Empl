package com.rs.eis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
	
	Optional<Book> findByName(String name);

	
	// List<Book> findByName(String name);
	 
	/*
	 * Optional<Book> findById(String name);
	 */
}
