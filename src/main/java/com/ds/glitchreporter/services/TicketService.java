package com.ds.glitchreporter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.dto.MessageDTO;
import com.ds.glitchreporter.dto.TicketDTO;
import com.ds.glitchreporter.dto.TicketPageDTO;
import com.ds.glitchreporter.dto.response.TicketPreviewDTO;
import com.ds.glitchreporter.models.Message;
import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.repository.MessageRepository;
import com.ds.glitchreporter.repository.TicketRepository;

import org.springframework.data.domain.Page;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	MessageService messageService;

	// Helper class to get an object from a repository
	public <T> T getObjectById(Long id, JpaRepository<T, Long> repository) {
		Optional<T> optionalObject = repository.findById(id);
        if (optionalObject.isPresent()) {
            return optionalObject.get();
        } else {
            return null;
        }
    }
	
	/**
	   * Returns a pageable list of tickets preview. This is deprecated, use getFilteredTicketsPage instead
	   * @param page The requested page
	   * @param pageSize The size of the page
	   * @return ticketPageDTO A list of tickets preview along with the amount of total tickets as well.
	   */
	public TicketPageDTO getTicketsPage(int page, int pageSize) {
        long totalTickets = ticketRepository.getTotalTicketsCount();

        // Returns a pageable ticket for the specified page
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, "id"));

        List<Ticket> ticketsForPage = ticketRepository.getTicketsForPage(pageable);

        // Mappa la lista di Ticket in una lista di TicketDTO (se necessario)
        List<TicketPreviewDTO> ticketDTOList = ticketsForPage.stream()
                .map(this::mapToTicketPreviewDTO)
                .collect(Collectors.toList());

        // Crea il DTO della pagina dei ticket
        TicketPageDTO ticketPageDTO = new TicketPageDTO();
        ticketPageDTO.setTotalTickets(totalTickets);
        ticketPageDTO.setTicketList(ticketDTOList);

        return ticketPageDTO;
    }

	/**
	   * Returns a pageable list of tickets preview based on active filters sent by the frontend.
	   * @param page The requested page
	   * @param pageSize The size of the page
	   * @param priorityIds The list of ticket priority IDs requested
	   * @param statusIds The list of ticket status IDs requested
	   * @return ticketPageDTO A list of tickets preview along with the amount of total tickets as well.
	   */
	
    public TicketPageDTO getFilteredTicketsPage(Integer page, Integer pageSize, List<Long> priorityIds, List<Long> statusIds ) {

        Pageable pageable = PageRequest.of(page - 1, pageSize);
           
        Page<Ticket> ticketPage = ticketRepository.findTicketsByPriorityIdsAndStatusIds(
                        priorityIds,
                        statusIds,
                        pageable
                );
      
        long totalTickets = ticketPage.getTotalElements();
        
        List<TicketPreviewDTO> ticketDTOList = ticketPage.stream()
                .map(this::mapToTicketPreviewDTO)
                .collect(Collectors.toList());

        // Create and return the TicketPageDTO
        TicketPageDTO ticketPageDTO = new TicketPageDTO();
        ticketPageDTO.setTicketList(ticketDTOList);
        ticketPageDTO.setTotalTickets(totalTickets);

        return ticketPageDTO;
    }
    
    /**
	   * Mapping from a Ticket object to a TicketPreviewDTO object.
	   * @param ticket The ticket object.
	   * @return ticketPreviewDTO The ticket preview generated from the ticket.
	   */
    
    public TicketPreviewDTO mapToTicketPreviewDTO(Ticket ticket) {
    	
    	TicketPreviewDTO ticketPreviewDTO = new TicketPreviewDTO(ticket);
    	
    	return ticketPreviewDTO;
    }
    
    /**
	   * Mapping from a Ticket object to a TicketDTO object.
	   * @param ticket The ticket object.
	   * @return ticketDTO The DTO generated from the ticket.
	   */
    
    public TicketDTO mapToTicketDTO(Ticket ticket) {
    	
    	List<Message> messages = ticket.getMessages();
    	
    	List<MessageDTO> messagesDTO = new ArrayList<>();
		
		for (Message message : messages) {
	    	 
			MessageDTO messageDTO = messageService.mapToMessageDTO(message);
	    	 
	    	 messagesDTO.add(messageDTO);
	     }
		
		TicketDTO ticketDTO = new TicketDTO(ticket);
		
		ticketDTO.setMessages(messagesDTO);
    	
    	return ticketDTO;
    }
    
}
