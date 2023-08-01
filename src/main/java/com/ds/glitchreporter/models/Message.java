package com.ds.glitchreporter.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    private User sender;

    @NotBlank
    private String message;
    
    private ZonedDateTime messageDate;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    
    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UploadedFile> uploadedFiles = new ArrayList<>();
    
    // getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ZonedDateTime getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(ZonedDateTime messageDate) {
		this.messageDate = messageDate;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<UploadedFile> getUploadedFiles() {
		return uploadedFiles;
	}

	public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}
    
	public Message() {
		
	}
}