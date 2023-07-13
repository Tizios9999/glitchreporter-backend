package com.ds.glitchreporter.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.repository.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    // Aggiungi qui i metodi per la logica di business legata a Priority
}