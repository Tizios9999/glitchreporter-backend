package com.ds.glitchreporter.dto;

import java.util.List;

public class TicketDTO {

	private Long ticketId;
	private String ticketSubject;
    private Integer priorityId;
    private Integer statusId;
    private Long openingUserId;
    private String openingUser;
    private Long assignedToId;
    private String assignedTo;
    private Integer topicId;
    private String creationDate;
    private String lastUpdated;
    private List<MessageDTO> messages;
    
	public TicketDTO(Long ticketId, String ticketSubject, Integer priorityId, Integer statusId,
			Long openingUserId, String openingUser, Long assignedToId, String assignedTo, Integer topicId,
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

	public Integer getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
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

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
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
    
	
    
}
