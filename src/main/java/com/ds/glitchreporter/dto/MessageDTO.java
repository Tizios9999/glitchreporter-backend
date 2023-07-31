package com.ds.glitchreporter.dto;

import java.util.List;

public class MessageDTO {
	
	private Long ticketId;
	private Long senderId;
	private String sender;
	private String message;
	private String messageDate;
	private List<UploadedFileDTO> uploadedFiles;
	
	public MessageDTO(Long ticketId, Long senderId, String sender, String message, String messageDate,
			List<UploadedFileDTO> uploadedFiles) {
		
		this.ticketId = ticketId;
		this.senderId = senderId;
		this.sender = sender;
		this.message = message;
		this.messageDate = messageDate;
		this.uploadedFiles = uploadedFiles;
	}
	
	// Getters and Setters

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public List<UploadedFileDTO> getUploadedFiles() {
		return uploadedFiles;
	}

	public void setUploadedFiles(List<UploadedFileDTO> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}

	@Override
	public String toString() {
		return "MessageDTO [ticketId=" + ticketId + ", senderId=" + senderId + ", sender=" + sender + ", message="
				+ message + ", messageDate=" + messageDate + ", uploadedFiles=" + uploadedFiles + "]";
	}
	
	
}
