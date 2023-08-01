package com.ds.glitchreporter.security.services;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.repository.MessageRepository;
import com.ds.glitchreporter.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	MessageRepository messageRepository;

	public <T> T getObjectById(Long id, JpaRepository<T, Long> repository) {
		Optional<T> optionalObject = repository.findById(id);
        if (optionalObject.isPresent()) {
            return optionalObject.get();
        } else {
            return null;
        }
    }
	
//	public void createTicket(TicketDTO ticketDTO) {
//        Message message = new Message();
//        message.setMessage(ticketDTO.getMessageDTO().getMessage());
//        message.setMessageDate(ticketDTO.getMessageDTO().getMessageDate());
//        message.setSender(ticketDTO.getMessageDTO().getSender());
//
//        List<UploadedFile> uploadedFiles = new ArrayList<>();
//        for (UploadedFileDTO uploadedFileDTO : ticketDTO.getMessageDTO().getUploadedFiles()) {
//            UploadedFile uploadedFile = new UploadedFile();
//            uploadedFile.setFileName(uploadedFileDTO.getFileName());
//            uploadedFile.setFileType(uploadedFileDTO.getFileType());
//            uploadedFile.setFileContent(uploadedFileDTO.getFileContent());
//
//            uploadedFiles.add(uploadedFile);
//        }
//
//        message.setUploadedFiles(uploadedFiles);
//        messageRepository.save(message);
//
//        Ticket ticket = new Ticket();
//        ticket.setTicketSubject(ticketDTO.getTicketSubject());
//        ticket.setCreationDate(ticketDTO.getCreationDate());
//        ticket.setLastUpdated(ticketDTO.getLastUpdated());
//        ticket.setPriority(ticketDTO.getPriority());
//        ticket.setStatus(ticketDTO.getStatus());
//        ticket.setTopic(ticketDTO.getTopic());
//        ticket.setOpeningUser(ticketDTO.getOpeningUser());
//        ticket.setAssignedTo(ticketDTO.getAssignedTo());
//        ticket.getMessages().add(message);
//        message.setTicket(ticket);
//
//        ticketRepository.save(ticket);
//    }
}
