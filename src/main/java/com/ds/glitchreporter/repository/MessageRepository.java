package com.ds.glitchreporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.glitchreporter.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
