package com.ds.glitchreporter.dto;

import java.util.List;

public class TicketDTO {

	private Long ticketId;
	private String ticketSubject;
    private Long priorityId;
    private Long statusId;
    private Long openingUserId;
    private String openingUser;
    private Long assignedToId;
    private String assignedTo;
    private Long topicId;
    private String creationDate;
    private String lastUpdated;
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
