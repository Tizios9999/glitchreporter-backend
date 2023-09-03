package com.ds.glitchreporter.models;

import java.time.ZonedDateTime;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;



@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String ticketSubject;
    
    private ZonedDateTime creationDate;
    private ZonedDateTime lastUpdated;
    
    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;
    
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    
    @ManyToOne
    @JoinColumn(name = "opening_user_id")
    private User openingUser;

    @ManyToOne
    @JoinColumn(name = "assigned_to_user_id")
    private User assignedTo;
    
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();
    
    // getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketSubject() {
		return ticketSubject;
	}

	public void setTicketSubject(String ticketSubject) {
		this.ticketSubject = ticketSubject;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ZonedDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(ZonedDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getOpeningUser() {
		return openingUser;
	}

	public void setOpeningUser(User openingUser) {
		this.openingUser = openingUser;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Ticket() {
		
	}
	
	
}