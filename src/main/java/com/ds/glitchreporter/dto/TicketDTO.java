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
    
    // Costruttore, getter e setter
}
