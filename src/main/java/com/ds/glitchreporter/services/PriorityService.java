package com.ds.glitchreporter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.repository.PriorityRepository;

@Service
public class PriorityService {
	
	@Autowired
    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

}