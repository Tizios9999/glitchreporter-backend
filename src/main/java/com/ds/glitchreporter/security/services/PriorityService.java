package com.ds.glitchreporter.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.repository.PriorityRepository;

@Service
public class PriorityService {
    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    // Aggiungi qui i metodi per la logica di business legata a Priority
}