package com.ds.glitchreporter.controllers;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.glitchreporter.dto.MessageDTO;
import com.ds.glitchreporter.dto.TicketDTO;
import com.ds.glitchreporter.dto.TicketResponseDTO;
import com.ds.glitchreporter.dto.UploadedFileDTO;
import com.ds.glitchreporter.models.Priority;
import com.ds.glitchreporter.models.Status;
import com.ds.glitchreporter.models.Topic;
import com.ds.glitchreporter.models.UploadedFile;
import com.ds.glitchreporter.models.User;
import com.ds.glitchreporter.models.Message;
import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.repository.MessageRepository;
import com.ds.glitchreporter.repository.PriorityRepository;
import com.ds.glitchreporter.repository.StatusRepository;
import com.ds.glitchreporter.repository.TicketRepository;
import com.ds.glitchreporter.repository.TopicRepository;
import com.ds.glitchreporter.repository.UploadedFileRepository;
import com.ds.glitchreporter.repository.UserRepository;
import com.ds.glitchreporter.security.services.TicketService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	
	private static final Long DEFAULT_STATUS_ID = (long) 1; 

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	UserRepository userRepository;
	
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
	public ResponseEntity<TicketResponseDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
		
		System.out.println("Ticket data: " + ticketDTO.toString());
		
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
	     
	     DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
	     ZonedDateTime creationDate = ZonedDateTime.parse(ticketDTO.getCreationDate(), formatter);
	     ZonedDateTime updateDate = ZonedDateTime.parse(ticketDTO.getLastUpdated(), formatter);
	     
	     // parse to change to ZonedDateTime, format to change ZonedDateTime to String.
	     
	     User user = ticketService.getObjectById(ticketDTO.getOpeningUserId(), userRepository);
	     
	     MessageDTO messageDTO = ticketDTO.getMessages().get(0);
	     
	     List<UploadedFileDTO> uploadedFilesDTO = messageDTO.getUploadedFiles();
	     
	     List<UploadedFile> uploadedFiles = new ArrayList<>();
	     
	     for (UploadedFileDTO fileDTO : uploadedFilesDTO) {
	    	 UploadedFile uploadedFile = new UploadedFile();
	    	 uploadedFile.setName(fileDTO.getName());
	    	 uploadedFile.setPath(fileDTO.getPath());
	    	 
	    	 uploadedFiles.add(uploadedFile);
	     }
	     
	     Message message = new Message();
	     
	     message.setMessage(messageDTO.getMessage());
	     message.setMessageDate(ZonedDateTime.parse(messageDTO.getMessageDate(), formatter));
	     message.setSender(user);
	     message.setUploadedFiles(uploadedFiles);
	     
	     Ticket ticket = new Ticket();
	     
	     List<Message> messages = new ArrayList<>();
	     
	     messages.add(message);
	     
	     ticket.setMessages(messages);
	     ticket.setTicketSubject(ticketDTO.getTicketSubject());
	     ticket.setPriority(priority);
	     ticket.setStatus(status);
	     ticket.setOpeningUser(user);
	     ticket.setTopic(topic);
	     ticket.setCreationDate(ZonedDateTime.parse(messageDTO.getMessageDate(), formatter));
	     ticket.setLastUpdated(ZonedDateTime.parse(messageDTO.getMessageDate(), formatter));
	     
	     message.setTicket(ticket);
	     
	     message.setUploadedFiles(uploadedFiles);
	     
	     for (UploadedFile file : uploadedFiles) {
	    	 file.setMessage(message);
	     }
	     
	     Long createdTicketId = ticketRepository.saveAndReturnId(ticket);
	     
	     TicketResponseDTO responseDTO = new TicketResponseDTO();
	     responseDTO.setTicketId(createdTicketId);
	     
		return ResponseEntity.ok(responseDTO);
	}
}
