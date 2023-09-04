package com.ds.glitchreporter.dto.request;

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
