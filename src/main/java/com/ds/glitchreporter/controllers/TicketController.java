package com.ds.glitchreporter.controllers;

import java.time.ZonedDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ds.glitchreporter.dto.MessageDTO;
import com.ds.glitchreporter.dto.TicketDTO;
import com.ds.glitchreporter.dto.TicketPageDTO;
import com.ds.glitchreporter.dto.UploadedFileDTO;
import com.ds.glitchreporter.dto.request.UpdateTicketStatusRequestDTO;
import com.ds.glitchreporter.dto.response.TicketResponseDTO;
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
import com.ds.glitchreporter.services.TicketService;

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
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_AGENT') or hasRole('ROLE_ADMIN')")
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
	     
	     List<Message> messages = new ArrayList<>();
	     
	     messages.add(message);
	     
	     Ticket ticket = new Ticket(ticketDTO.getTicketSubject(), priority, status, topic, user, creationDate, updateDate, messages);
 
	     message.setTicket(ticket);
	     
	     for (UploadedFile file : uploadedFiles) {
	    	 file.setMessage(message);
	     }
	     
	     Long createdTicketId = ticketRepository.saveAndReturnId(ticket);
	     
	     TicketResponseDTO responseDTO = new TicketResponseDTO();
	     responseDTO.setTicketId(createdTicketId);
	     
		return ResponseEntity.ok(responseDTO);
	}
	
	@GetMapping("/getpage")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_AGENT') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<TicketPageDTO> getPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
		
		TicketPageDTO ticketPageDTO = ticketService.getTicketsPage(page, pageSize);
		
		System.out.println(ticketPageDTO);
		
		return ResponseEntity.ok(ticketPageDTO);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_AGENT') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
		
		System.out.println("request arrived");
		
	    Optional<Ticket> optionalTicket = ticketRepository.findById(id);
	    
	    if (optionalTicket.isPresent()) {
	        Ticket ticket = optionalTicket.get();

	        TicketDTO ticketDTO = ticketService.mapToTicketDTO(ticket);
	        
	        System.out.println(ticketDTO);

	        return ResponseEntity.ok(ticketDTO);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PutMapping("/{ticketId}/update-status")
	@PreAuthorize("hasRole('ROLE_AGENT') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> updateTicketStatus(
	    @PathVariable Long ticketId,
	    @RequestBody UpdateTicketStatusRequestDTO updateRequest) {
	    
	    // Estrai i dati dalla richiesta
	    Long newStatusId = updateRequest.getTicketStatusId();
	    Long newAssignedUserId = updateRequest.getNewAssignedUserId();
	    
	    Ticket ticket = ticketService.getObjectById(ticketId, ticketRepository);

	    Status newStatus = ticketService.getObjectById(newStatusId, statusRepository);
	    
	    User newAssignedUser = ticketService.getObjectById(newAssignedUserId, userRepository);
	    
	    // Update the ticket with the new values
	    ticket.setStatus(newStatus);
	    ticket.setAssignedTo(newAssignedUser);

	    // Save the updated ticket
	    ticketRepository.save(ticket);

	    return ResponseEntity.ok("Ticket updated successfully");
	}
	
	@PostMapping("/{ticketId}/add-message")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_AGENT') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> addMessageToTicket(
	    @PathVariable Long ticketId,
	    @RequestBody MessageDTO messageDTO) {
	    
		Ticket ticket = ticketService.getObjectById(ticketId, ticketRepository);

		User sender = ticketService.getObjectById(messageDTO.getSenderId(), userRepository);
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
	    ZonedDateTime messageDate = ZonedDateTime.parse(messageDTO.getMessageDate(), formatter);
		
	    Message newMessage = new Message();
	    newMessage.setTicket(ticket);
	    newMessage.setMessage(messageDTO.getMessage());
	    newMessage.setSender(sender);
	    newMessage.setMessageDate(messageDate);
	    
	    List<UploadedFileDTO> uploadedFilesDTO = messageDTO.getUploadedFiles();
	    
	    List<UploadedFile> uploadedFiles = new ArrayList<>();
	     
	     for (UploadedFileDTO fileDTO : uploadedFilesDTO) {
	    	 UploadedFile uploadedFile = new UploadedFile();
	    	 uploadedFile.setName(fileDTO.getName());
	    	 uploadedFile.setPath(fileDTO.getPath());
	    	 uploadedFile.setMessage(newMessage);
	    	 
	    	 uploadedFiles.add(uploadedFile);
	     }
	    
	    newMessage.setUploadedFiles(uploadedFiles);
	    ticket.getMessages().add(newMessage);	    
	    ticket.setLastUpdated(messageDate);

	    ticketRepository.save(ticket);

	    return ResponseEntity.ok("Message added to the ticket");
	}
	
	@GetMapping("/getfilteredpage")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_AGENT') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<TicketPageDTO> getFilteredPage(
            @RequestParam Integer page,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) String priorityIds,
            @RequestParam(required = false) String statusIds) {

		System.out.println("page " + page);
		System.out.println("pageSize " + pageSize);
		System.out.println("priorityIds " + priorityIds);
		System.out.println("statusIds " + statusIds);
		
		List<Long> priorityIdList = Arrays.asList(priorityIds.substring(1, priorityIds.length() - 1).split(",")).stream().map(Long::parseLong).collect(Collectors.toList());	
		List<Long> statusIdList = Arrays.asList(statusIds.substring(1, statusIds.length() - 1).split(",")).stream().map(Long::parseLong).collect(Collectors.toList());
	    
        TicketPageDTO ticketPageDTO = ticketService.getFilteredTicketsPage(
                page, pageSize, priorityIdList, statusIdList);

        return ResponseEntity.ok(ticketPageDTO);
    }

}
