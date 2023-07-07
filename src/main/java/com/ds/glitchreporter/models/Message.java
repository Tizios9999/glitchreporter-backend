package com.ds.glitchreporter.models;

import java.time.LocalDateTime;
import java.util.HashSet;
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

    private String message;
    private LocalDateTime messageDate;
    private String type;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    // getters and setters
}