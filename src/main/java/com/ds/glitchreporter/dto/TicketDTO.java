package com.ds.glitchreporter.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.utils.TicketUtils;

/**
 * Data Transfer Object (DTO) for representing ticket information in the GlitchReporter application.
 * This class is used to transfer ticket-related data between different parts of the application.
 */

public class TicketDTO {

	/**
     * The unique identifier of the ticket.
     */
	private Long ticketId;
	 
	/**
     * The subject or title of the ticket.
     */
	private String ticketSubject;
    
	/**
     * The identifier of the priority associated with the ticket.
     */
	private Long priorityId;
	
	/**
     * The identifier of the status of the ticket.
     */
    private Long statusId;
    
    /**
     * The identifier of the user who opened the ticket.
     */
    private Long openingUserId;
    
    /**
     * The username of the user who opened the ticket.
     */
    private String openingUser;
    
    /**
     * The identifier of the user to whom the ticket is assigned.
     */
    private Long assignedToId;
    
    /**
     * The username of the user to whom the ticket is assigned.
     */
    private String assignedTo;
    
    /**
     * The identifier of the topic associated with the ticket.
     */
    private Long topicId;
    
    /**
     * The creation date and time of the ticket in ISO offset format.
     */
    private String creationDate;
    
    /**
     * The date and time when the ticket was last updated in ISO offset format.
     */
    private String lastUpdated;
    
    /**
     * The list of messages associated with the ticket, represented as MessageDTO objects.
     */
    private List<MessageDTO> messages;
    
	public TicketDTO(Long ticketId, String ticketSubject, Long priorityId, Long statusId,
			Long openingUserId, String openingUser, Long assignedToId, String assignedTo, Long topicId,
			String creationDate, String lastUpdated, List<MessageDTO> messages) {
		
		this.ticketId = ticketId;
		this.ticketSubject = ticketSubject;
		this.priorityId = priorityId;
		this.statusId = statusId;
		this.openingUserId = openingUserId;
		this.openingUser = openingUser;
		this.assignedToId = assignedToId;
		this.assignedTo = assignedTo;
		this.topicId = topicId;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.messages = messages;
		
	}
	
	public TicketDTO(Ticket ticket) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
		
		this.ticketId = ticket.getId();
		this.ticketSubject = ticket.getTicketSubject();
		this.priorityId = ticket.getPriority().getId();
		this.statusId = ticket.getStatus().getId();
		this.openingUserId = ticket.getOpeningUser().getId();
		this.openingUser = TicketUtils.getOpeningUserUsername(ticket);
		this.assignedToId = TicketUtils.getAssignedToUsernameId(ticket);
		this.assignedTo = TicketUtils.getAssignedToUsername(ticket);
		this.topicId = ticket.getTopic().getId();
		this.creationDate = ticket.getCreationDate().format(formatter);
		this.lastUpdated = ticket.getLastUpdated().format(formatter);
	}
	
	// Getters and Setters

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketSubject() {
		return ticketSubject;
	}

	public void setTicketSubject(String ticketSubject) {
		this.ticketSubject = ticketSubject;
	}

	public Long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getOpeningUserId() {
		return openingUserId;
	}

	public void setOpeningUserId(Long openingUserId) {
		this.openingUserId = openingUserId;
	}

	public String getOpeningUser() {
		return openingUser;
	}

	public void setOpeningUser(String openingUser) {
		this.openingUser = openingUser;
	}

	public Long getAssignedToId() {
		return assignedToId;
	}

	public void setAssignedToId(Long assignedToId) {
		this.assignedToId = assignedToId;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<MessageDTO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDTO> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketId=" + ticketId + ", ticketSubject=" + ticketSubject + ", priorityId=" + priorityId
				+ ", statusId=" + statusId + ", openingUserId=" + openingUserId + ", openingUser=" + openingUser
				+ ", assignedToId=" + assignedToId + ", assignedTo=" + assignedTo + ", topicId=" + topicId
				+ ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + ", messages=" + messages + "]";
	}
  
}
