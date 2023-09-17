package com.ds.glitchreporter.dto.response;

/**
 * Data Transfer Object (DTO) for representing a response containing a ticket ID in the GlitchReporter application.
 * This class is used to transfer a ticket's unique identifier as a response, typically after creating a new ticket.
 */

public class TicketResponseDTO {
	
	private Long ticketId;

	public TicketResponseDTO() {
		
	}
	
	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	
	
}
