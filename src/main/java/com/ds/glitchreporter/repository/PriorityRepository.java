package com.ds.glitchreporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.glitchreporter.models.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Integer> {

}
