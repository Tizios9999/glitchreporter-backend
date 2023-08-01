package com.ds.glitchreporter.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.glitchreporter.models.Priority;
import com.ds.glitchreporter.models.Status;
import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.models.User;

import jakarta.transaction.Transactional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Optional<Ticket> findById(Long id);
    
    List<Ticket> findByAssignedToOrderByCreationDateDesc(User assignedTo);
    
    List<Ticket> findByOpeningUserOrderByCreationDateDesc(User openingUser);
    
    List<Ticket> findByStatusOrderByCreationDateDesc(Status status);
    
    List<Ticket> findByPriorityOrderByCreationDateDesc(Priority priority);
    
    List<Ticket> findByPriorityInOrderByCreationDateDesc(Set<Priority> priorities);
    
    @Transactional
    default Long saveAndReturnId(Ticket ticket) {
        Ticket savedTicket = save(ticket);
        return savedTicket.getId();
    }
	
}
