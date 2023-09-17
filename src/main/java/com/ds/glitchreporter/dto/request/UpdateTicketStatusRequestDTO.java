package com.ds.glitchreporter.dto.request;

/**
 * Data Transfer Object (DTO) for representing a request to update the status of a ticket in the GlitchReporter application.
 * This class is used to transfer information about the new status and, optionally, the user to whom the ticket is assigned.
 */

public class UpdateTicketStatusRequestDTO {

	private Long ticketStatusId;
	private Long newAssignedUserId;
	
	public Long getTicketStatusId() {
		return ticketStatusId;
	}
	public void setTicketStatusId(Long ticketStatusId) {
		this.ticketStatusId = ticketStatusId;
	}
	public Long getNewAssignedUserId() {
		return newAssignedUserId;
	}
	public void setNewAssignedUserId(Long newAssignedUserId) {
		this.newAssignedUserId = newAssignedUserId;
	}
	
	
	
}
