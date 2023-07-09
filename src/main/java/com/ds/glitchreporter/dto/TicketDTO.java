package com.ds.glitchreporter.dto;

import java.util.List;

public class TicketDTO {

	private String ticketId;
	private String ticketSubject;
    private String priorityId;
    private String statusId;
    private String openingUserId;
    private String assignedToId;
    private String topicId;
    private String creationDate;
    private String lastUpdated;
    private List<MessageDTO> messages;
    
	public TicketDTO(String ticketId, String ticketSubject, String priorityId, String statusId, String openingUserId,
			String assignedToId, String topicId, String creationDate, String lastUpdated, List<MessageDTO> messages) {
		this.ticketId = ticketId;
		this.ticketSubject = ticketSubject;
		this.priorityId = priorityId;
		this.statusId = statusId;
		this.openingUserId = openingUserId;
		this.assignedToId = assignedToId;
		this.topicId = topicId;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.messages = messages;
	}

    // getters & setters
	
	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketSubject() {
		return ticketSubject;
	}

	public void setTicketSubject(String ticketSubject) {
		this.ticketSubject = ticketSubject;
	}

	public String getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(String priorityId) {
		this.priorityId = priorityId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getOpeningUserId() {
		return openingUserId;
	}

	public void setOpeningUserId(String openingUserId) {
		this.openingUserId = openingUserId;
	}

	public String getAssignedToId() {
		return assignedToId;
	}

	public void setAssignedToId(String assignedToId) {
		this.assignedToId = assignedToId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
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
