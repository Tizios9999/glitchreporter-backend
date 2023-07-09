package com.ds.glitchreporter.dto;

import java.time.LocalDate;

public class MessageDTO {
	
	private Long ticketId;
	private String senderId;
	private String sender;
	private String message;
	private LocalDate date;
	
	public MessageDTO(Long ticketId, String senderId, String sender, String message, LocalDate date) {
		this.ticketId = ticketId;
		this.senderId = senderId;
		this.sender = sender;
		this.message = message;
		this.date = date;
	}
	
	
	
}
