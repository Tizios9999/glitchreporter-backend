package com.ds.glitchreporter.dto.response;

import java.time.format.DateTimeFormatter;

import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.utils.TicketUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object (DTO) for representing a preview of a ticket in the GlitchReporter application.
 * This class is used to transfer summarized information about a ticket, including its subject, customer, status,
 * priority, assigned user, and last update date, to be sent to the Frontend.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketPreviewDTO {
	
	@JsonProperty("ticketId")
	private Long ticketId;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("customer")
	private String customer;
	
	@JsonProperty("statusId")
	private Long statusId;
	
	@JsonProperty("priorityId")
	private Long priorityId;
	
	@JsonProperty("assignedTo")
	private String assignedTo;
	
	@JsonProperty("lastUpdated")
	private String lastUpdated;
	
	public TicketPreviewDTO() {
		
	}
	
	public TicketPreviewDTO(Ticket ticket) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
		
		this.ticketId = ticket.getId();
		this.subject = ticket.getTicketSubject();
		this.customer = TicketUtils.getOpeningUserUsername(ticket);
		this.statusId = ticket.getStatus().getId();
		this.priorityId = ticket.getPriority().getId();
		this.assignedTo = TicketUtils.getAssignedToUsername(ticket);
		this.lastUpdated = ticket.getLastUpdated().format(formatter);
		
	}

	@Override
	public String toString() {
		return "TicketPreviewDTO [ticketId=" + ticketId + ", subject=" + subject + ", customer=" + customer
				+ ", statusId=" + statusId + ", priorityId=" + priorityId + ", assignedTo=" + assignedTo
				+ ", lastUpdated=" + lastUpdated + "]";
	}
	
	
}
