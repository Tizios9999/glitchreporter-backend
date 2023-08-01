package com.ds.glitchreporter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.glitchreporter.models.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findAll();
	
	Optional<Topic> findById(Long id);
}