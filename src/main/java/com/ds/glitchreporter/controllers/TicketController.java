package com.ds.glitchreporter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.glitchreporter.dto.TicketDTO;
import com.ds.glitchreporter.repository.MessageRepository;
import com.ds.glitchreporter.repository.TicketRepository;
import com.ds.glitchreporter.repository.UploadedFileRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	UploadedFileRepository uploadedFileRepository;
	
	@PostMapping("/post")
	public ResponseEntity<Void> createTicket(@RequestBody TicketDTO ticketDTO) {
		System.out.println("Ticket subject: " + ticketDTO.getTicketSubject());
		
		return ResponseEntity.ok().build();
	}
}
