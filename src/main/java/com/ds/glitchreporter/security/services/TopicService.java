package com.ds.glitchreporter.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    // Aggiungi qui i metodi per la logica di business legata a Priority
}