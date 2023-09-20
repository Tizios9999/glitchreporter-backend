package com.ds.glitchreporter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.glitchreporter.dto.MetadataDTO;
import com.ds.glitchreporter.dto.response.MessageResponseDTO;
import com.ds.glitchreporter.models.Priority;
import com.ds.glitchreporter.models.Topic;
import com.ds.glitchreporter.models.Status;
import com.ds.glitchreporter.repository.PriorityRepository;
import com.ds.glitchreporter.repository.StatusRepository;
import com.ds.glitchreporter.repository.TopicRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/metadata")
public class MetadataController {

	@Autowired
	PriorityRepository priorityRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	// returns the ticket metadata
	@GetMapping("/get")
    public ResponseEntity<?> getMetadata() {
		
		try {
		
			List<Priority> priorities = priorityRepository.findAll();
	        List<Status> statuses = statusRepository.findAll();
	        List<Topic> topics = topicRepository.findAll();

	        MetadataDTO metadataDTO = new MetadataDTO(topics, priorities, statuses);

	        return ResponseEntity.ok(metadataDTO);
			
		}
		
		catch (Exception e) {
			String errorMessage = e.getMessage();
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(new MessageResponseDTO("An internal error occurred while fetching ticket metadata: " + errorMessage));
		}
		        
    }
}
