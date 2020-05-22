package com.rs.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.Library;
@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
	
	Optional<Library> findById(int id);

	List<Library> findByBookid(int bookid);
}
