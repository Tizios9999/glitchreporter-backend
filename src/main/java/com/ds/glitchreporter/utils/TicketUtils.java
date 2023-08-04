package com.ds.glitchreporter.utils;

import com.ds.glitchreporter.models.Ticket;
import com.ds.glitchreporter.models.User;

public class TicketUtils {

	public static String getAssignedToUsername(Ticket ticket) {
        User assignedTo = ticket.getAssignedTo();
        if (assignedTo != null) {
            return assignedTo.getUsername();
        } else {
            return "Unassigned";
        }
    }
}
