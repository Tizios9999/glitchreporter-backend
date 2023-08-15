package com.ds.glitchreporter.security.services;

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
import com.ds.glitchreporter.dto.TicketPreviewDTO;
import com.ds.glitchreporter.models.Message;
import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.repository.MessageRepository;
import com.ds.glitchreporter.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	MessageService messageService;

	public <T> T getObjectById(Long id, JpaRepository<T, Long> repository) {
		Optional<T> optionalObject = repository.findById(id);
        if (optionalObject.isPresent()) {
            return optionalObject.get();
        } else {
            return null;
        }
    }
	
	public TicketPageDTO getTicketsPage(int page, int pageSize) {
        long totalTickets = ticketRepository.getTotalTicketsCount();

        // Crea un oggetto Pageable per ottenere i ticket per la pagina specificata
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

    // Metodo per mappare Ticket a TicketDTO (se necessario)
    public TicketPreviewDTO mapToTicketPreviewDTO(Ticket ticket) {
    	
    	TicketPreviewDTO ticketPreviewDTO = new TicketPreviewDTO(ticket);
    	
    	return ticketPreviewDTO;
    }
    
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
    
    public TicketPageDTO getFilteredTicketsPage(Integer page, Integer pageSize, List<Long> priorityIds, List<Long> statusIds ) {

        Pageable pageable = PageRequest.of(page, pageSize);
        
        System.out.println("level 2: priorityIds " + priorityIds);
        System.out.println("level 2: statusIds " + statusIds);

        // Get all tickets that match either statusIds or priorityIds
        List<Ticket> ticketList = ticketRepository.findTicketsByPriorityIdsOrStatusIds(
                priorityIds,
                statusIds
        );
        
        System.out.println("ticket list " + ticketList);

        // Filter out tickets that don't match both statusIds and priorityIds
        if (!statusIds.contains(0) && !priorityIds.contains(0)) {
            ticketList.removeIf(ticket -> !statusIds.contains(ticket.getStatus().getId()) || !priorityIds.contains(ticket.getPriority().getId()));
        }
        
        List<TicketPreviewDTO> ticketDTOList = ticketList.stream()
                .map(this::mapToTicketPreviewDTO)
                .collect(Collectors.toList());

        // Create and return the TicketPageDTO
        TicketPageDTO ticketPageDTO = new TicketPageDTO();
        ticketPageDTO.setTicketList(ticketDTOList);
        ticketPageDTO.setTotalTickets(ticketRepository.count());

        return ticketPageDTO;
    }
}
