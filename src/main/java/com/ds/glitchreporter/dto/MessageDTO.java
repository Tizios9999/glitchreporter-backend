package com.ds.glitchreporter.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ds.glitchreporter.models.Message;
import com.ds.glitchreporter.utils.MessageUtils;

/**
 * Data Transfer Object (DTO) for representing ticket messages in the GlitchReporter application.
 * This class is used to transfer message-related information between different parts of the application,
 * such as controllers, services, and views.
 */

public class MessageDTO {
	
	private Long ticketId;
	private Long senderId;
	private String sender;
	private String message;
	private String messageDate;
	private List<UploadedFileDTO> uploadedFiles;
	
	/**
     * Constructs a new MessageDTO object with the provided information.
     *
     * @param ticketId      The unique identifier of the ticket associated with this message.
     * @param senderId      The unique identifier of the sender of this message.
     * @param sender        The name or username of the sender of this message.
     * @param message       The content of the message.
     * @param messageDate   The date and time when the message was sent, formatted as a string.
     * @param uploadedFiles A list of DTOs representing uploaded files attached to this message.
     */
	
	public MessageDTO(Long ticketId, Long senderId, String sender, String message, String messageDate,
			List<UploadedFileDTO> uploadedFiles) {
		
		this.ticketId = ticketId;
		this.senderId = senderId;
		this.sender = sender;
		this.message = message;
		this.messageDate = messageDate;
		this.uploadedFiles = uploadedFiles;
	}
	
	/**
     * Constructs a new MessageDTO object by extracting information from a Message entity.
     *
     * @param message The Message entity from which to extract information.
     */
	
	public MessageDTO(Message message) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
		
		this.ticketId = message.getTicket().getId();
		this.senderId = message.getSender().getId();
		this.sender = MessageUtils.getMessageSender(message);
		this.message = message.getMessage();
		this.messageDate = message.getMessageDate().format(formatter);
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
