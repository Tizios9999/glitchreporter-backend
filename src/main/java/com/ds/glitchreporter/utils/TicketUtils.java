package com.ds.glitchreporter.utils;

import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.models.User;

/**
 * Utility class for handling operations related to tickets.
 */
public class TicketUtils {

    /**
     * Gets the username of the user to whom the ticket is assigned.
     *
     * @param ticket The Ticket entity for which the assigned user's username is determined.
     * @return A string representation of the assigned user's username, "Ex User" if deleted, or "Unassigned" if not assigned.
     */	
	public static String getAssignedToUsername(Ticket ticket) {
        User assignedTo = ticket.getAssignedTo();
        if (assignedTo != null) {
        	
        	if (assignedTo.isDeleted()) {
        		return "Ex User";
        	} else {
        		return assignedTo.getUsername();
        	}
        	
            
        } else {
            return "Unassigned";
        }
    }

    /**
     * Gets the ID of the user to whom the ticket is assigned.
     *
     * @param ticket The Ticket entity for which the assigned user's ID is determined.
     * @return The ID of the assigned user or 0 if not assigned.
     */
	public static Long getAssignedToUsernameId(Ticket ticket) {
        User assignedTo = ticket.getAssignedTo();
        if (assignedTo != null) {
            return assignedTo.getId();
        } else {
            return (long) 0;
        }
    }

    /**
     * Gets the username of the user who opened the ticket.
     *
     * @param ticket The Ticket entity for which the opening user's username is determined.
     * @return A string representation of the opening user's username or "Ex User" if deleted.
     */
	public static String getOpeningUserUsername(Ticket ticket) {
		
		User openingUser = ticket.getOpeningUser();
		
		if (openingUser.isDeleted()) {
			return "Ex User";
		} else {
			return openingUser.getUsername();
		}
		
	}
}
