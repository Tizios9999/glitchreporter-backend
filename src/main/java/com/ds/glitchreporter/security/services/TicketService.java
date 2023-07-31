package com.ds.glitchreporter.security.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	public <T> T getObjectById(Integer id, JpaRepository<T, Integer> repository) {
		Optional<T> optionalObject = repository.findById(id);
        if (optionalObject.isPresent()) {
            return optionalObject.get();
        } else {
            return null;
        }
    }
	
}
