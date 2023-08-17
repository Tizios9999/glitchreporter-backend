package com.ds.glitchreporter.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    
    List<Ticket> findByStatusIdInOrderByCreationDateDesc(List<Long> statusIds);
    
    List<Ticket> findByPriorityIdInOrderByCreationDateDesc(List<Long> priorityIds);
    
    @Query("SELECT t FROM Ticket t WHERE t.priority.id IN :priorityIds OR t.status.id IN :statusIds ORDER BY t.creationDate DESC")
    List<Ticket> findTicketsByPriorityIdsOrStatusIds(@Param("priorityIds") List<Long> priorityIds, @Param("statusIds") List<Long> statusIds, Pageable pageable);
    
    @Query("SELECT COUNT(t) FROM Ticket t")
    long getTotalTicketsCount();

    @Query("SELECT t FROM Ticket t ORDER BY t.id DESC")
    List<Ticket> getTicketsForPage(Pageable pageable);
    
    @Transactional
    default Long saveAndReturnId(Ticket ticket) {
        Ticket savedTicket = save(ticket);
        return savedTicket.getId();
    }
	
}
