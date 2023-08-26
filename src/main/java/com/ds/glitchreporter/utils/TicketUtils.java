package com.ds.glitchreporter.utils;

import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.models.User;

public class TicketUtils {

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
	
	public static Long getAssignedToUsernameId(Ticket ticket) {
        User assignedTo = ticket.getAssignedTo();
        if (assignedTo != null) {
            return assignedTo.getId();
        } else {
            return (long) 0;
        }
    }
	
	public static String getOpeningUserUsername(Ticket ticket) {
		
		User openingUser = ticket.getOpeningUser();
		
		if (openingUser.isDeleted()) {
			return "Ex User";
		} else {
			return openingUser.getUsername();
		}
		
	}
}
