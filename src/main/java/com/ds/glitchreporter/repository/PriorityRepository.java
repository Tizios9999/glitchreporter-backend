package com.ds.glitchreporter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.glitchreporter.models.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
	
	List<Priority> findAll();
	
	Optional<Priority> findById(Long id);

}
