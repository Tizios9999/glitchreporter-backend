package com.ds.glitchreporter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.glitchreporter.models.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

	List<Topic> findAll();
}