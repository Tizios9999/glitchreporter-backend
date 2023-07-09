package com.ds.glitchreporter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.glitchreporter.models.Priority;
import com.ds.glitchreporter.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

	List<Status> findAll();
}