package com.ds.glitchreporter.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.glitchreporter.dto.TicketDTO;
import com.ds.glitchreporter.models.Priority;
import com.ds.glitchreporter.models.Status;
import com.ds.glitchreporter.models.Topic;
import com.ds.glitchreporter.repository.MessageRepository;
import com.ds.glitchreporter.repository.PriorityRepository;
import com.ds.glitchreporter.repository.StatusRepository;
import com.ds.glitchreporter.repository.TicketRepository;
import com.ds.glitchreporter.repository.TopicRepository;
import com.ds.glitchreporter.repository.UploadedFileRepository;
import com.ds.glitchreporter.security.services.TicketService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	
	private static final Integer DEFAULT_STATUS_ID = 1; 

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	UploadedFileRepository uploadedFileRepository;
	
	@Autowired
	PriorityRepository priorityRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/post")
	public ResponseEntity<Void> createTicket(@RequestBody TicketDTO ticketDTO) {
		
		System.out.println("Ticket data: " + ticketDTO.toString());
		
//		Optional <Priority> priorityOptional = priorityRepository.findById(ticketDTO.getPriorityId());
//		
//		if (priorityOptional.isPresent()) {
//	        Priority priority = priorityOptional.get();
//	        String priorityName = priority.getName();
//	        System.out.println("Priority is: " + priorityName);
//	    } else {
//	        // La priorità con l'id specificato non esiste nel database
//	        System.out.println("Priority not found");
//	    }
//		
//		Optional <Topic> topicOptional = topicRepository.findById(ticketDTO.getTopicId());
//		
//		if (topicOptional.isPresent()) {
//	        Topic topic = topicOptional.get();
//	        String topicName = topic.getName();
//	        System.out.println("Topic is: " + topicName);
//	    } else {
//	        // Il topic con l'id specificato non esiste nel database
//	        System.out.println("Topic not found");
//	    }
		
		 Priority priority = ticketService.getObjectById(ticketDTO.getPriorityId(), priorityRepository);
	     String priorityName = priority.getName();
	     System.out.println("Priority is: " + priorityName);

	     Topic topic = ticketService.getObjectById(ticketDTO.getTopicId(), topicRepository);
	     String topicName = topic.getName();
	     System.out.println("Topic is: " + topicName);
	     
	     if (ticketDTO.getStatusId() == null) {
	    	 ticketDTO.setStatusId(DEFAULT_STATUS_ID);
	     }
	     
	     Status status = ticketService.getObjectById(ticketDTO.getStatusId(), statusRepository);
	     String statusName = status.getName();
	     System.out.println("Status is: " + statusName);
		
		return ResponseEntity.ok().build();
	}
}
