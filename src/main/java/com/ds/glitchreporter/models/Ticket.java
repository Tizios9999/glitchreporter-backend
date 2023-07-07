package com.ds.glitchreporter.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketSubject;
    private String ticketId;
    private LocalDateTime creationDate;
    
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

    private LocalDateTime lastUpdated;
    
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    // getters and setters
}