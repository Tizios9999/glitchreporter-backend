package com.ds.glitchreporter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.glitchreporter.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByTicketId(Long ticketId);
}
